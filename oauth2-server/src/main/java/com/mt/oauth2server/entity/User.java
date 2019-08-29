package com.mt.oauth2server.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * author: liqm
 * 2019-08-23
 */
@Data
@Table(name = "tb_user")
@Entity
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;

}
