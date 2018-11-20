package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private String hello = "hello";

    public Controller( @Value("${welcome.message}") String hello) {
        this.hello = hello;
    }

    @RequestMapping ("/")
    public String getMessage(String name){

        return hello;
    }
}
