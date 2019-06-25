package com.craigecomputing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("com.cc")
@Data
public class AppConfig {
    private String firstName;
    private String lastName;
    private Proprietary proprietary;


    @Data
    public static class Proprietary {
        private String registeredName;
        private Integer ccDate;
    }

}
