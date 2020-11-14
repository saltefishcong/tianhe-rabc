package com.congcong.rabc.controller;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Employee;
import com.congcong.rabc.pojo.Temp;
import com.congcong.rabc.service.DepartmentService;
import com.congcong.rabc.service.EmployeeService;
import com.congcong.rabc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:45
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/saveOrUpdate" ,method = RequestMethod.POST)
    public String departmentSave(Employee employee,@RequestParam(value = "roleIds") List<Long> roleIds){
        System.out.println(employee + "  saveOrUpdate  " + new Date());
        employeeService.save(employee,roleIds);
        return "forward:/employee/list";
    }

    @RequestMapping(value = "/list")
    public String departmentList(Model model, Integer currentPage,String keyword,Long deptId){
        Page<Employee> all = null;
        if(keyword == null && deptId == null){
            all = employeeService.findAll(currentPage == null ? 1 :currentPage , 10);
        }else{
            List<Long> deptIds = new ArrayList<>();
            if(deptId == -1) {
                List<Department> deptAll = departmentService.findAll();
                deptAll.stream().forEach( e -> {
                    deptIds.add(e.getId());
                });
            }else{
                deptIds.add(deptId);
            }
            all = employeeService.findByNameOrEmailAndDepartmentId(keyword,deptIds,currentPage == null ? 1 :currentPage , 10);

            Temp temp = new Temp();
            temp.setKeyword(keyword);
            temp.setDeptId(deptId);
            model.addAttribute("qo",temp);
        }
        System.out.println(all.getContent());
        System.out.println(all.getTotalElements() + "    "+ all.getTotalPages());
        model.addAttribute("departments",departmentService.findAll());
        model.addAttribute("pageResult",all);
        return "/employee/list";
    }

    @RequestMapping(value = "/input")
    public String departmentInput(Model model,Employee employee){
        System.out.println(employee +"  input  " + new Date());
        model.addAttribute("employee",employeeService.findEmployeeById(employee));
        model.addAttribute("departments",departmentService.findAll());
        model.addAttribute("roles",roleService.findAll());
        return "/employee/input";
    }

    @RequestMapping(value = "/delete")
    public String departmentDeleteById(Long id){
        employeeService.delete(id);
        return "forward:/employee/list";
    }

}
