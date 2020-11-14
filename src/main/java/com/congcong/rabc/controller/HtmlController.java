package com.congcong.rabc.controller;

import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HtmlController
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/14 , 13:28
 * @Version 1.0
 **/
@Controller
public class HtmlController {

//    @RequestMapping(value = "/department/input")
    public String getDepartmentInputHtml(){
        return "/department/input";
    }

//    @RequestMapping(value = "/department/list")
    public String getDepartmentListHtml(){
        return "/department/list";
    }

//    @RequestMapping(value = "/employee/input")
    public String getEmployeeInputHtml(){
        return "/employee/input";
    }

//    @RequestMapping(value = "/employee/list")
    public String getEmployeeListHtml(){
        return "/employee/list";
    }

//    @RequestMapping(value = "/permission/list")
    public String getPermissionListHtml(){
        return "/permission/list";
    }

//    @RequestMapping(value = "/role/input")
    public String getRoleInputHtml(){
        return "/role/input";
    }

//    @RequestMapping(value = "/role/list")
    public String getRoleListHtml(){
        return "/role/list";
    }

}
