package com.template.spring_server.rest;

import com.template.spring_server.Application;
import com.template.spring_server.helper.PropertyOverride;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoleController.class)
@ContextConfiguration(initializers = PropertyOverride.class, classes = Application.class)
@AutoConfigureMockMvc
public class RoleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(jsr250Enabled = true)
    static class Configuration extends KeycloakTestConfiguration {
    }

    @Test
    @WithMockUser(username = "user", roles = "user")
    public void user() throws Exception {
        mockMvc.perform(get("/api/rolebased/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("User request"));

    }

    @Test
    public void admin() {
    }
}
