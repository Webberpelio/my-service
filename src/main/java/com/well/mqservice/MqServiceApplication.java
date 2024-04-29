package com.well.mqservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zwell
 */
@SpringBootApplication
public class MqServiceApplication {

    public static void main(String[] args) {
        System.out.println("启动");
        SpringApplication.run(MqServiceApplication.class, args);
        System.out.println("启动成功");
    }

}
