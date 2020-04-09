package com.template.spring_server.rest;

import com.template.spring_server.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
    private TestModel testModel;

    @GetMapping("/ping")
    public @ResponseBody
    ResponseEntity<String> ping() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/model_inject")
    public @ResponseBody
    ResponseEntity<String> modelInject() {
        if (testModel == null)
            return new ResponseEntity<>("test model is not injected", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @Autowired
    public void setTestModel(TestModel testModel) {
        this.testModel = testModel;
    }
}
