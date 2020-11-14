package com.congcong.rabc.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName RolePermission
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:41
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;
}
