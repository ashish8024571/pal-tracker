package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String hello;

    public WelcomeController( @Value("${welcome.message}") String hello) {
        this.hello = hello;
    }

    @RequestMapping ("/")
    public String sayHello(){

        return hello;
    }
}
