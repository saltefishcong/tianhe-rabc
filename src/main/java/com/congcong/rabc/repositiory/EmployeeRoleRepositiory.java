package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.EmployeeRole;
import com.congcong.rabc.pojo.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRoleRepositiory extends JpaRepository<EmployeeRole,Long> {

    List<EmployeeRole> findAllByEmployeeId(Long employeeId);

    EmployeeRole findByRoleIdAndEmployeeId(Long roleId,Long employeeId);
}
