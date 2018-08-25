package io.pivotal.c2c.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Api {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/demo")
    public String demo(){
//        String response = System.getenv("TEST");
        String response = environment.getProperty("vcap.application.instance_id");
        log.info("Response from env: " + response);
        return response;
    }

}
