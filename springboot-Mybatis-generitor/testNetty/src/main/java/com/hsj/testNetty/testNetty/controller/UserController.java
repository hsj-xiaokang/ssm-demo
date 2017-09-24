package com.hsj.testNetty.testNetty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hsj.testNetty.testNetty.pojo.User;
import com.hsj.testNetty.testNetty.service.IUserService;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUserById(@RequestParam("id") String id){
        User user=userService.getUserById(id);
        String userStr= JSON.toJSONString(user);
        return userStr;
    }
}
