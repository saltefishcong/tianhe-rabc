package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Permission;
import com.congcong.rabc.repositiory.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PermissionService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:32
 * @Version 1.0
 **/
@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public void save(Permission permission){
        permissionRepository.save(permission);
    }

    public void saveAll(List<Permission> permissions){
        permissionRepository.saveAll(permissions);
    }

    public void update(Permission permission){
        save(permission);
    }

    public void updateAll(List<Permission> permissions){
        saveAll(permissions);
    }

    public void delete(Long id){
        permissionRepository.deleteById(id);
    }

    public void deleteAll(List<Permission> permissions){
         permissionRepository.deleteInBatch(permissions);
    }

    public Page<Permission> findAll(int page, int size){
        return findAllAndPage(PageRequest.of(page - 1,size, Sort.by(Sort.Direction.DESC   ,"id")));
    }

    private Page<Permission> findAllAndPage(Pageable pageable){
        return permissionRepository.findAll(pageable);
    }

    public Permission findByName(String name){
        return permissionRepository.findByName(name);
    }
}
