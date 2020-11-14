package com.congcong.rabc.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:40
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sn")
    private String sn;
}
