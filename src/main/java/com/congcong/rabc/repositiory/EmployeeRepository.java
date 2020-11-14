package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    Page<Employee> findAllByIsAdmin(boolean isAdmin,Pageable pageable);

//    Page<Employee> findByNameLikeOrEmailAndDeptIdIn(String nameContent,String emailContent,  List<Long> departmentId,Pageable pageable);

    Page<Employee> findAll(Specification<Employee> specification, Pageable pageable);

//    Page<Employee> findAllByDeptIdInAndNameLikeOrEmail(List<Long> DeptIds,String name,String email,Pageable pageable);
}
