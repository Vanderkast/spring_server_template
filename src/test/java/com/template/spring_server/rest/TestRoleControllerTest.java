package com.template.spring_server.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestRoleControllerTest {

    @Test
    public void anon() {
    }

    @Test
    public void user() {
    }

    @Test
    public void admin() {
    }
}
