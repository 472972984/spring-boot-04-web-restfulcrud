package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }


    @RequestMapping("/success")
    public String testThymeleaf(Map<String,Object> map){
        //默认到该路径下：  classpath:/templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

    //返回的字符串直接是视图名称
    @PostMapping("/user/login")
    public String login(@RequestParam String username , @RequestParam String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //如果密码为123456   账号随意  就可以登录成功
            //return "dashboard";

            //存放登录信息
            session.setAttribute("loginUser",username);

            //防止表单重复提交，使用重定向
             return "redirect:/main.html";
        }else{
            //登录失败
            //提示错误消息
            map.put("msg","密码错误");
            return "login";
        }
    }



}
