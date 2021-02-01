package com.tydic.consumer.controller;

import com.tydic.api.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/01/26 18:36
 */
@RestController
public class UserController {

    @Reference(version = "com.tydic.provider.service.user.UserServiceImpl", group = "user", check = false)
    private UserService userService;

    @GetMapping (value = "/hello")
    public String hello() {
        String hello = userService.sayHello("Along");
        System.out.println(hello);
        return hello;
    }

    @GetMapping(value = "/sum")
    public int sum(){
        int rsp = userService.sum(52, 25);
        System.out.println(rsp);
        return rsp;
    }



}
