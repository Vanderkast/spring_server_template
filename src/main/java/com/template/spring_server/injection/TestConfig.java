package com.template.spring_server.injection;

import com.template.spring_server.model.TestModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(lazyInit = true)
public class TestConfig {
    @Bean
    TestModel beanTestModel() {
        return new TestModel("test");
    }
}
