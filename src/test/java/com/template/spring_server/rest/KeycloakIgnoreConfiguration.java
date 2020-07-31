package com.template.spring_server.rest;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.Filter;
import java.lang.reflect.Field;
import java.util.List;

public class KeycloakIgnoreConfiguration extends WebSecurityConfigurerAdapter {
    @SuppressWarnings("unchecked")
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Field field = http.getClass().getDeclaredField("filters");
        field.setAccessible(true);
        ((List<Filter>) field.get(http)).removeIf(
                filter -> filter.getClass().toString().startsWith("Keycloak"));
    }
}
