package com.jiawa.train.number.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liushuailong
 * @version 1.0
 * @date 2024/2/4 18:17
 */

@SpringBootApplication
@ComponentScan("com.jiawa")
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
    }
}
