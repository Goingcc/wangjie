package com.wj.demo.controller;

import com.alibaba.fastjson.JSON;
import com.wj.demo.model.User;
import com.wj.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wangjie
 * @data 2019/1/24 13:19
 */
@Controller
public class UserController {
    Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/getUserById")
    @Cacheable("id")
    public ModelAndView getUserById(int id){
        //指定数据返回将要跳转的页面：user.jsp
        ModelAndView modelAndView = new ModelAndView("user");

        User user= userService.getUser(id);
        //将返回结果加入到ModelAndView对象中
        log.info("查询到的数据："+user.getUserName()+user.getSex()+user.getBirthday());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
       List<User> users = userService.getAllUsers();
       log.info(""+ JSON.toJSONString(users));
       return users;
    }


}
