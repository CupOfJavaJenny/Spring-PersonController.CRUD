package io.zipcoder.crudapp.config;

import io.zipcoder.crudapp.CRUDApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CRUDAppConfig {
    @Bean
    public CRUDApplication crudApplication() {
        return new CRUDApplication();
    }
}
//added some configuration to the application,so it can know how to run...brought to you in part by Jake