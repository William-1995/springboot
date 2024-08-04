package com.inaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = InactionApplication.class)
class InactionApplicationTests {


    @Autowired
    private ApplicationContext context;


    @Test
    void contextLoads() {

        InactionApplication.main(new String[]{
            // Override any other environment properties according to your needs
        });

        Assertions.assertTrue(context.containsBean("userService"));
    }
}
