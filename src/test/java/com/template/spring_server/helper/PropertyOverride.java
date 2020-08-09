package com.template.spring_server.helper;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

public class PropertyOverride implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.realm=spring-test");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.auth-server-url=http://172.18.80.24:8180/auth");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.ssl-required=external");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.resource=ui-service");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.credentials.secret=00156bdb-291b-4209-ae67-372578dc0f79");
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, "keycloak.bearer-only=true");
    }
}
