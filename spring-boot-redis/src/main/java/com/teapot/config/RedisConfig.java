package com.teapot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    /**
     * 创建JedisPoolConfig对象
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        System.out.println("默认值：" + config.getMaxIdle());
        System.out.println("默认值：" + config.getMinIdle());
        System.out.println("默认值：" + config.getMaxTotal());
        return config;
    }

    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
        System.out.println("配置完毕："+config.getMaxIdle());
        System.out.println("配置完毕："+config.getMinIdle());
        System.out.println("配置完毕："+config.getMaxTotal());

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(config);
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 设置key序列化
        template.setKeySerializer(new StringRedisSerializer());
        // 设置value序列化
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}
