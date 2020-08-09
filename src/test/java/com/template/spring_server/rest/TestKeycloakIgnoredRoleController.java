package com.template.spring_server.rest;

import com.template.spring_server.model.TestModel;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoleController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Ignore
public class TestKeycloakIgnoredRoleController {
    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    static class Config extends KeycloakIgnoreConfiguration {
        @Bean
        TestModel beanTestModel() {
            return new TestModel("ok");
        }
    }

    @Test
    public void anon() throws Exception {
        mockMvc.perform(get("/api/rolebased/anon"))
                .andExpect(status().isOk())
                .andExpect(content().string("Anonymous request"));
    }

    @Test
    public void user() throws Exception {
        mockMvc.perform(get("/api/rolebased/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("User request"));
    }

    @Test
    public void admin() throws Exception {
        mockMvc.perform(get("/api/rolebased/admin"))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin request"));
    }
}
