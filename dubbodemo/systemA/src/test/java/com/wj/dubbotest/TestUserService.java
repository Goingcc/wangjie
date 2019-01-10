package com.wj.dubbotest;

import com.wj.dubbo.systemb.pojo.User;
import com.wj.dubbo.systemb.service.UserService;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wangjie
 * @data 2018/12/12 10:53
 * 测试用例
 */
public class TestUserService {
    private UserService userService;

    @Before
    public void setup()throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo/*.xml");
//        this.userService = (UserService) applicationContext.getBean("userService");
        this.userService = applicationContext.getBean(UserService.class);
    }
    @Test
    public void testQueryAll(){
        List<User> users = this.userService.queryAll();
        System.out.println("测试结果为：");
        for(User user:users){
            System.out.println(user);
        }
    }

}
