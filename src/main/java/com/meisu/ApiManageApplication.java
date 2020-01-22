package com.meisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableConfigurationProperties
public class ApiManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiManageApplication.class, args);
    }

}
