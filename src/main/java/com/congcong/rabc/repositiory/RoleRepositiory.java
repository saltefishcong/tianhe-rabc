package com.congcong.rabc.repositiory;

import com.congcong.rabc.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositiory extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
