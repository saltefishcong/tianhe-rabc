package com.congcong.rabc.controller;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Permission;
import com.congcong.rabc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PermissionController
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:46
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list")
    public String permissionList(Model model, Integer currentPage){
        Page<Permission> all = permissionService.findAll(currentPage == null ? 1 :currentPage , 10);
        System.out.println(all.getContent());
        model.addAttribute("pageResult",all);
        return "/permission/list";
    }

    @RequestMapping(value = "/reload")
    public String permissionReload(){
        return "forward:/permission/list";
    }

    @RequestMapping(value = "/delete")
    public String permissionDelete(Long id){
        permissionService.delete(id);
        return "forward:/permission/list";
    }
}
