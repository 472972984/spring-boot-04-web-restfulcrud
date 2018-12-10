package com.atguigu.springboot;

import com.atguigu.springboot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04WebRestfulcrudApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    public void contextLoads() {
        System.err.println(helloService.say());
    }


}
