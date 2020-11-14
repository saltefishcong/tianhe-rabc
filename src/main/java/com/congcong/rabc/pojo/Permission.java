package com.congcong.rabc.pojo;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:36
 * @Version 1.0
 **/

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "expression")
    private String expression;
}
