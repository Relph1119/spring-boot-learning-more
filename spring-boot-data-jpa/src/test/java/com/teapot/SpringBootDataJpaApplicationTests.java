package com.teapot;

import com.teapot.dao.UserRepository;
import com.teapot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDataJpaApplicationTests {

    @Autowired
    private UserRepository repository;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("gupao");
        user.setAge(4);
        repository.save(user);
    }

}
