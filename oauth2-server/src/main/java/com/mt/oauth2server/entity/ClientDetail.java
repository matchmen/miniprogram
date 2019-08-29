package com.mt.oauth2server.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * author: liqm
 * 2019-08-26
 */
@Table(name = "tb_client_detail")
@Entity
@Data
public class ClientDetail {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "SECRET")
    private String secret;

    @Column(name = "GRANT_TYPE")
    private String grantType;

    @Column(name = "SCOPE")
    private String scope;

    @Column(name = "REDIRECT_URL")
    private String redirectUrl;




}
