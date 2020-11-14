package com.congcong.rabc.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:10
 * @Version 1.0
 **/
@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name="age")
    private Integer age;

    @Column(name = "admin")
    private Boolean isAdmin;

    @Column(name = "dept_id")
    private Long deptId;
}
