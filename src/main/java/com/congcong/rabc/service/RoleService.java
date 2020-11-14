package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Role;
import com.congcong.rabc.repositiory.RoleRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:41
 * @Version 1.0
 **/
@Service
public class RoleService {

    @Autowired
    private RoleRepositiory roleRepositiory;

    public void save(Role role){
        roleRepositiory.save(role);
    }

    public void saveAll(List<Role> roles){
        roleRepositiory.saveAll(roles);
    }

    public void update(Role role){
        save(role);
    }

    public void updateAll(List<Role> roles){
        saveAll(roles);
    }

    public void delete(Long id){
        roleRepositiory.deleteById(id);
    }

    public void deleteAll(List<Role> roles){
        roleRepositiory.deleteInBatch(roles);
    }

    public Role findByName(String name){
        return roleRepositiory.findByName(name);
    }

    public Page<Role> findAll(int page, int size){
        return findAllAndPage(PageRequest.of(page - 1,size, Sort.by(Sort.Direction.DESC   ,"id")));
    }

    private Page<Role> findAllAndPage(Pageable pageable){
        return roleRepositiory.findAll(pageable);
    }
}
