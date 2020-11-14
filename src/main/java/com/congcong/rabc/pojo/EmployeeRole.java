package com.congcong.rabc.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName EmployeeRole
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:15
 * @Version 1.0
 **/
@Entity
@Table(name = "employee_role")
@Data
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "role_id")
    private Long roleId;
}
