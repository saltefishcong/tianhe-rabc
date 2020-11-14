package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PermissionRepositiory
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 23:28
 * @Version 1.0
 **/
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Permission findByName(String name);
}
