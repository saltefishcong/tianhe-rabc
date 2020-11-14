package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Employee;
import com.congcong.rabc.pojo.EmployeeRole;
import com.congcong.rabc.pojo.Role;
import com.congcong.rabc.repositiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:20
 * @Version 1.0
 **/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeService employeeService;

    public void save(Employee employee,List<Long> roleIds){
        employeeRoleService.deleteAllByEmployeeId(employee.getId());
        employee.setDeptId(employee.getDept().getId());
        employee.setIsAdmin(employee.getIsAdmin() == null ? false : employee.getIsAdmin());
        Employee save = employeeRepository.save(employee);
        List<EmployeeRole> employeeRoles = new ArrayList<>(16);
        roleIds.stream().forEach( e -> {
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployeeId(save.getId());
            employeeRole.setRoleId(e);
            employeeRoles.add(employeeRole);
        });
        employeeRoleService.saveAll(employeeRoles);
    }

    public Employee login(String email, String password){
        return employeeRepository.findByEmailAndPassword(email,password);
    }

    public Page<Employee> findAll(int page, int size){
        Page<Employee> all = findAllAndPage(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id")));
        all.getContent().stream().forEach( e -> {
            e.setDept(departmentService.findById(e.getDeptId()));
            e.setRoles(findRolesByEmployeeId(e));
        });
        return all;
    }

    public Employee findEmployeeById(Employee employee){
        if(employee == null || employee.getId() == null) return null;
        Employee byId = employeeService.findById(employee.getId());
        byId.setRoles(findRolesByEmployeeId(byId));
        return byId;
    }

    private List<Role> findRolesByEmployeeId(Employee e){
        if(e == null ) return null;
        List<EmployeeRole> allByEmployeeId = employeeRoleService.findAllByEmployeeId(e.getId());
        List<Role> roles = new ArrayList<>(16);
        allByEmployeeId.stream().forEach( o -> {
            roles.add(roleService.findById(o.getRoleId()));
        });
        return roles;
    }

    private Page<Employee> findAllAndPage(Pageable pageable){
        return employeeRepository.findAllByIsAdmin(false,pageable);
    }

    public Employee findById(Long id){
        if(id == null ) return null;
        return employeeRepository.findById(id).orElse(null);
    }

    public void update(Employee employee){
        save(employee,null);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
        employeeRoleService.deleteAllByEmployeeId(id);
    }

    public Page<Employee> findByNameOrEmailAndDepartmentId(String content , List<Long> departmentIds,int page, int size){
        Page<Employee> all = employeeRepository.findAll(
                new Specification<Employee>() {
                    @Override
                    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        List<Predicate> list = new ArrayList<>(16);
                        list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + content + "%"));
                        list.add(criteriaBuilder.like(root.get("email").as(String.class),"%" + content + "%"));
                        Predicate[] ors = new Predicate[list.size()];
                        Predicate or = criteriaBuilder.or(list.toArray(ors));

                        CriteriaBuilder.In<Long> deptIds = criteriaBuilder.in(root.get("deptId").as(Long.class));
                        for(Long deptId : departmentIds){
                            deptIds.value(deptId);
                        }
                       criteriaQuery.where(criteriaBuilder.and(or,deptIds));
                        return criteriaQuery.getRestriction();
                    }
                }
                , PageRequest.of(page - 1, size));

        all.getContent().stream().forEach( e -> {
            e.setDept(departmentService.findById(e.getDeptId()));
            e.setRoles(findRolesByEmployeeId(e));
        });
        return all;
    }
}
