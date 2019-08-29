package com.mt.oauth2server.suports;

import com.mt.oauth2server.entity.User;
import com.mt.oauth2server.repository.UserReporsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * author: liqm
 * 2019-08-23
 */
@Component
public class MyUserDetailSerice implements UserDetailsService {

    @Autowired
    private UserReporsity userReporsity;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

         User user = userReporsity.findByUsername(s);

         if(Objects.isNull(user)){
             return null;
         }

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());

        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), true, true, true, true, Arrays.asList(simpleGrantedAuthority));

        return user1;
    }
}
