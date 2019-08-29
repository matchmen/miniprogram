package com.mt.oauth2server.repository;

import com.mt.oauth2server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: liqm
 * 2019-08-23
 */
public interface UserReporsity extends JpaRepository<User,User> {

    public User findByUsername(String username);

}
