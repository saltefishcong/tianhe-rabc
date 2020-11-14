package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositiory extends JpaRepository<Department,Long> {


}
