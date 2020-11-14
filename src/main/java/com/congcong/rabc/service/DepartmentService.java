package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.repositiory.DepartmentRepositiory;
import com.sun.crypto.provider.DESCipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:49
 * @Version 1.0
 **/
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepositiory departmentRepositiory;

    public Department findById(Long id){
        return departmentRepositiory.findById(id).orElse(null);
    }

    public Page<Department> findAll(int page, int size){
        return findAllAndPage(PageRequest.of(page - 1,size,Sort.by(Sort.Direction.DESC   ,"id")));
    }

    private Page<Department> findAllAndPage(Pageable pageable){
        return departmentRepositiory.findAll(pageable);
    }

    public void save(Department department){
        departmentRepositiory.save(department);
    }

    public void update(Department department){
        departmentRepositiory.save(department);
    }

    public void saveAll(List<Department> departments){
        departmentRepositiory.saveAll(departments);
    }

    public void update(List<Department> departments){
        saveAll(departments);
    }

    public void delete(Long id){
        departmentRepositiory.deleteById(id);
    }

    public void deleteList(List<Department> departments){
        departments.stream().forEach( e -> {
            delete(e.getId());
        });
    }
}
