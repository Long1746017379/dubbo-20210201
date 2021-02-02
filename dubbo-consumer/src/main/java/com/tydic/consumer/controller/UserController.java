package com.tydic.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.tydic.api.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/sub")
    public int sub(@RequestBody JSONObject jsonObject){
        // 增加注释
        Integer num1 = jsonObject.getInteger("num1");
        Integer num2 = jsonObject.getInteger("num2");
        int sub = userService.sub(num1, num2);
        System.out.println(sub);
        return sub;
    }

}
