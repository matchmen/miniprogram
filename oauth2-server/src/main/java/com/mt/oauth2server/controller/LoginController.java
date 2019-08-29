package com.mt.oauth2server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * author: liqm
 * 2019-08-16
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {


        return "login";
    }

}
