package com.tydic.provider.service.user;

import com.tydic.api.service.user.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/01/26 16:10
 */

@Component
@Service(version = "com.tydic.provider.service.user.UserServiceImpl", interfaceClass = UserService.class, timeout = 5000, group = "user")
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello(String name) {
        return "你好啊：" + name;
    }

    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }


}
