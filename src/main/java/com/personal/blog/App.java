package com.personal.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.personal.blog.dao")
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

//        try {
//            String msg = null;
//            msg.length();
//        } catch (Exception exception) {
//            System.out.println(exception.getMessage());
//            log.error("==============hello log===============" + exception.getMessage());
//        }

        SpringApplication.run(App.class, args);
    }
}
