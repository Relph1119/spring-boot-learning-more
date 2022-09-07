package com.teapot;

import com.teapot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test01() {
        this.redisTemplate.opsForValue().set("name", "bobo");
    }

    @Test
    public void test02() {
        Object obj = this.redisTemplate.opsForValue().get("name");
        System.out.println(obj);
    }

    /**
     * 将User对象序列化为一个字符串存储
     */
    @Test
    public void test03() {
        User user = new User(1, "张三", "湖南长沙");
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("user", user);
    }

    /**
     * 将字符串反序列化成User对象
     */
    @Test
    public void test04() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    /**
     * 将User对象转换为JSON对象存储
     */
    @Test
    public void test05() {
        User user = new User(1, "李四", "湖南长沙");
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        redisTemplate.opsForValue().set("userJson", user);
    }

    @Test
    public void test06() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) this.redisTemplate.opsForValue().get("userJson");
        System.out.println(user);
    }
}
