package io.pivotal.c2cdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DemoApi {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/c2c")
    public ResponseEntity c2c() {
        try {
            return restTemplate.getForEntity("http://c2c.apps.internal:8080/demo", String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/java")
    public ResponseEntity java() {
        try {
//            return restTemplate.exchange("http://c2c-java.apps.internal:8080/demo",
//                    HttpMethod.GET,
//                    null,
//                    String.class);
            return restTemplate.getForEntity("http://c2c-java.apps.internal:8080/demo", String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/php")
    public ResponseEntity php() {
        try {
            return restTemplate.getForEntity("http://c2c-php.apps.internal:8080/demo", String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
