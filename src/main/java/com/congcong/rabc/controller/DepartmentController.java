package com.congcong.rabc.controller;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:45
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/saveOrUpdate" ,method = RequestMethod.POST)
    public String departmentSave(Department department){
        System.out.println(department + "   " + new Date());
        departmentService.save(department);
        return "forward:/department/list";
    }

    @RequestMapping(value = "/list")
    public String departmentList(Model model, Integer currentPage){
        Page<Department> all = departmentService.findAll(currentPage == null ? 1 :currentPage , 10);
        model.addAttribute("pageResult",all);
        return "/department/list";
    }

    @RequestMapping(value = "/input")
    public String departmentInput(Model model,Department department){
        model.addAttribute("dept",departmentService.findById(department.getId()));
        return "/department/input";
    }

    @RequestMapping(value = "/delete")
    public String departmentDeleteById(Long id){
        departmentService.delete(id);
        return "forward:/department/list";
    }
}
