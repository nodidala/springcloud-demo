package com.paul.consumerhello.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author paul
 * @date 2019/7/30 11:27
 */
@Controller
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/he")
    public String he() {
        return "test";
    }

    @GetMapping("/hello")
    public String hello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://serverHello/hello", String.class);
        System.out.println("responseEntity:" + responseEntity);

        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }
}
