package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Permission;
import com.congcong.rabc.pojo.Role;
import com.congcong.rabc.pojo.RolePermission;
import com.congcong.rabc.repositiory.RolePermissionRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName RolePermissionService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:55
 * @Version 1.0
 **/
@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionRepositiory rolePermissionRepositiory;

    public List<RolePermission> findAllByRoleId(Long roleId){
        return rolePermissionRepositiory.findAllByRoleId(roleId);
    }

    public List<RolePermission> findAll(){
        return rolePermissionRepositiory.findAll();
    }

    public RolePermission findByRoleIdAndPermissionId(Long roleId,Long permissionId){
        return rolePermissionRepositiory.findByRoleIdAndPermissionId(roleId,permissionId);
    }

    public void save(RolePermission rolePermission){
       rolePermissionRepositiory.save(rolePermission);
    }

    public void saveAll(List<RolePermission> rolePermissions){
        rolePermissionRepositiory.saveAll(rolePermissions);
    }

    public void delete(Long roleId,Long permissionId){
        rolePermissionRepositiory.delete(findByRoleIdAndPermissionId(roleId,permissionId));
    }

    public void deleteAll(Long roleId,Set<Long> permissionIds){
            permissionIds.stream().forEach( e -> {
                delete(roleId,e);
            });
    }
}
