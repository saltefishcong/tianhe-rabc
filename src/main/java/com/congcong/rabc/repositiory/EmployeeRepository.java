package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName EmployeeRepository
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:19
 * @Version 1.0
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByEmailAndPassword(String email,String password);

    Page<Employee> findAllByIsAdminNot(Pageable pageable);
}
