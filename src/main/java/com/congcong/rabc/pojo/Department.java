package com.congcong.rabc.pojo;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @ClassName Department
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/11/13 , 22:05
 * @Version 1.0
 **/
@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sn")
    private String sn;
}
