package com.wj.demo.test;

import com.wj.demo.model.User;
import com.wj.demo.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangjie
 * @data 2019/1/24 18:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyBatisCacheSecondTest {
    private static final Logger logger = Logger.getLogger(MyBatisCacheSecondTest.class);
    @Autowired
    private UserService userService;

    /*
     * 二级缓存测试
     */
    @Test
    public void testCache2() {
        User user1=userService.getUser(15);
        logger.info("测试二级缓存1:"+user1.getUserName());
        User user2 = userService.getUser(16);
        logger.info("测试二级缓存2:"+user2.getUserName());
    }

}
