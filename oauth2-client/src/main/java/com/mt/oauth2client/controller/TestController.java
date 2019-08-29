package com.mt.oauth2client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * author: liqm
 * 2019-08-16
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/securedPage")
    public String securedPage(){
        return "securedPage";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public String getUser(Principal principal){

        log.info("principal:{}", principal);

        return principal.getName();
    }

    @GetMapping("/miniprogram")
    @ResponseBody
    public String miniprogram(){
        return "first mini program request";
    }

}
