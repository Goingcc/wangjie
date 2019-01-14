package com.wj.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author wangjie
 * @data 2019/1/14 18:43
 * 使用redis的java接口jedis操作5种数据类型
 */
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("连接正在进行:"+jedis.ping("ping success  message"));
//        String类型
        jedis.set("name","wangjie");
        System.out.println("Redis存储的字符串为："+jedis.get("name"));
//        list类型
        jedis.lpush("wj-list","bjtu");
        jedis.lpush("wj-list","1881729918");
        jedis.lpush("wj-list","13281161");
        System.out.println("Redis存储的list为：");
        List list = jedis.lrange("wj-list",0,2);
       for(int i=0;i<list.size();i++){
           System.out.println("  "+list.get(i));
       }
//       set类型
       jedis.sadd("wj-set","setname ");
       jedis.sadd("wj-set","set_001");
       jedis.sadd("wj-set","set_password");
        System.out.println("Redis存储的set为："+jedis.smembers("wj-set"));
//        hash类型
        jedis.hset("wj-hash","hash_001","wangjie33");
        jedis.hset("wj-hash","hash_002","13281161@bjtu.edu.cn");
        System.out.println("redis存储的hash为："+jedis.hgetAll("wj-hash"));

//        zset类型
        jedis.zadd("wj-zset",5,"zhangsan");
        jedis.zadd("wj-zset",2,"lisi");
        jedis.zadd("wj-zset",3,"wangwu");
        System.out.println("redis存储的zset为："+jedis.zrange("wj-zset",0,10));
    }
}
