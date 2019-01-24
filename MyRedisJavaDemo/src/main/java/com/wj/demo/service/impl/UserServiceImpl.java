package com.wj.demo.service.impl;

import com.wj.demo.dao.UserDao;
import com.wj.demo.model.User;
import com.wj.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjie
 * @data 2019/1/15 15:47
 * 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果，
 * redis的查询速度之于MySQL的查询速度相当于 内存读写速度 /硬盘读写速度
 * @Cacheable("a") 注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b"},allEntries=true)  的意思就是执行该方法后要清除redis中key名称为a,b的数据；
 */
@Service
public class UserServiceImpl implements UserService {
    Logger log = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers(){
        List<User> list = null;
        try{
            list = userDao.getAllUsers();
        }catch(DataAccessException e){
            log.error("UserServiceImpl异常"+e);
        }
        return list;
    }
    @Override
    @Cacheable("a")
    public User getUser(int id){
        User user = null;
        try{
            user=userDao.getUserById(id);
        }catch(DataAccessException e){
            log.error("UserServiceImpl异常："+e);
        }
        return user;
    }

}
