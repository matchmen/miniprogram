package com.mt.oauth2client.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * author: liqm
 * 2019-08-16
 */
@Configuration
@EnableOAuth2Sso
public class OAuthClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**","/miniprogram")
                .permitAll()
                .anyRequest()
                .authenticated()
        .and().logout().logoutSuccessUrl("http://localhost:8080/auth/logout");
    }
}
