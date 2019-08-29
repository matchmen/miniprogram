package com.mt.oauth2server.config;

import com.mt.oauth2server.suports.MyClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

/**
 * author: liqm
 * 2019-08-16
 */
@Configuration
@EnableAuthorizationServer
public class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MyClientDetailsService myClientDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.jdbc(dataSource);
        clients.withClientDetails(myClientDetailsService);

//        clients.inMemory()
//                .withClient("mini-program") // clientId, 可以类比为用户名
//                .secret(passwordEncoder.encode("123")) // secret， 可以类比为密码
//                .authorizedGrantTypes("authorization_code")    // 授权类型，这里选择授权码
//                .scopes("user_info") // 授权范围
//                .autoApprove(true) // 自动认证
//                .redirectUris("http://localhost:8082/login")    // 认证成功重定向URL
//                .accessTokenValiditySeconds(10); // 超时时间，10s
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
