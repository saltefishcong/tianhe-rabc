package com.congcong.rabc.service;

import com.congcong.rabc.pojo.EmployeeRole;
import com.congcong.rabc.repositiory.EmployeeRepository;
import com.congcong.rabc.repositiory.EmployeeRoleRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName EmployeeRoleService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/14 , 0:15
 * @Version 1.0
 **/
@Service
public class EmployeeRoleService {

    @Autowired
    private EmployeeRoleRepositiory employeeRoleRepositiory;

    public List<EmployeeRole> findAllByEmployeeId(Long employeeId){
        return employeeRoleRepositiory.findAllByEmployeeId(employeeId);
    }

    public List<EmployeeRole> findAll(){
        return employeeRoleRepositiory.findAll();
    }

    public EmployeeRole findByEmployeeIdAndRoleId(Long roleId,Long employeeId){
        return employeeRoleRepositiory.findByRoleIdAndEmployeeId(roleId,employeeId);
    }

    public void save(EmployeeRole employeeRole){
        employeeRoleRepositiory.save(employeeRole);
    }

    public void saveAll(List<EmployeeRole> employeeRoles){
        employeeRoleRepositiory.saveAll(employeeRoles);
    }

    public void delete(Long roleId,Long employeeId){
        employeeRoleRepositiory.delete(findByEmployeeIdAndRoleId(roleId, employeeId));
    }

    public void deleteAll(Long employeeId, Set<Long> roleIds){
        roleIds.stream().forEach( e -> {
            delete(e,employeeId);
        });
    }
}
