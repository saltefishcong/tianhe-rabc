package com.congcong.rabc.service;

import com.congcong.rabc.pojo.Department;
import com.congcong.rabc.pojo.Employee;
import com.congcong.rabc.repositiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:20
 * @Version 1.0
 **/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee login(String email, String password){
        return employeeRepository.findByEmailAndPassword(email,password);
    }

    public Page<Employee> findAll(int page, int size){
        return findAllAndPage(PageRequest.of(page - 1,size, Sort.by(Sort.Direction.DESC   ,"id")));
    }

    private Page<Employee> findAllAndPage(Pageable pageable){
        return employeeRepository.findAllByIsAdminNot(pageable);
    }

    public void update(Employee employee){
        save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
