package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Permission;
import com.congcong.rabc.pojo.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepositiory extends JpaRepository<RolePermission,Long> {

    List<RolePermission> findAllByRoleId(Long roleId);

    RolePermission findByRoleIdAndPermissionId(Long roleId,Long permissionId);
}
