package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndiex;
    private String cfInstanceAddr;


    public EnvController(@Value("${port:8080}")String port,
                         @Value("${memoryLimit:1024}")String memoryLimit,
                         @Value("${cfInstanceIndiex:20}")String cfInstanceIndiex,
                         @Value("${cfInstanceAddr:2}")String cfInstanceAddr ) {
        this.port= port;
        this.memoryLimit=memoryLimit;
        this.cfInstanceIndiex=cfInstanceIndiex;
        this.cfInstanceAddr=cfInstanceAddr;
    }

    @GetMapping("/env")
    public String getEnv(){

        return "";

    }


}
