package com.wj.dubbo.systemb.service.impl;

import com.wj.dubbo.systemb.pojo.User;
import com.wj.dubbo.systemb.service.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjie
 * @data 2018/12/12 11:57
 */
public class UserServiceImpl implements UserService {

//      @Override
    public List<User>queryAll() {
          List<User> list = new ArrayList<User>();
          for (int i = 0; i < 10; i++) {
              User user = new User();
              user.setAge(20 + i);
              user.setId(Long.valueOf(i + 1));
              user.setPassword("123456");
              user.setName("username_" + i);
              list.add(user);
          }
          return list;
      }
}