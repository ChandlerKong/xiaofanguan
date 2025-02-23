package com.xiaofanguan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaofanguan.server.mapper")
public class XiaofanguanApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaofanguanApplication.class, args);
    }
}
