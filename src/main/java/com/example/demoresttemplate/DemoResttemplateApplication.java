package com.example.demoresttemplate;

import com.example.demoresttemplate.configs.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfig.class)
public class DemoResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoResttemplateApplication.class, args);
    }

}
