package com.congcong.rabc.controller;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Role;
import com.congcong.rabc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:45
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/saveOrUpdate" ,method = RequestMethod.POST)
    public String roleSave(Role role){
        System.out.println(role + "   " + new Date());
        roleService.save(role);
        return "forward:/role/list";
    }

    @RequestMapping(value = "/list")
    public String roleList(Model model, Integer currentPage){
        Page<Role> all = roleService.findAll(currentPage == null ? 1 :currentPage , 10);
        model.addAttribute("pageResult",all);
        return "/role/list";
    }

    @RequestMapping(value = "/input")
    public String roleInput(Model model,Role role){
        model.addAttribute("role",roleService.findById(role.getId()));
        return "/role/input";
    }

    @RequestMapping(value = "/delete")
    public String roleDeleteById(Long id){
        roleService.delete(id);
        return "forward:/role/list";
    }
}
