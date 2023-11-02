//package com.backend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public JedisPool jedisPool(){
//        return new JedisPool("localhost",6379);
//    }
//
//    @Bean
//    public Jedis jedis(JedisPool jedisPool){
//        return jedisPool.getResource();
//    }
//}
