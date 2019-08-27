package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private String port;
    private String memoryLimit;
    private String cfInstanceIndiex;
    private String cfInstanceAddr;
    public EnvController(@Value("${port:NOT SET}")String port,
                         @Value("${memoryLimit:NOT SET}")String memoryLimit,
                         @Value("${cfInstanceIndiex:NOT SET}")String cfInstanceIndiex,
                         @Value("${cfInstanceAddr:NOT SET}")String cfInstanceAddr ) {
        this.port= port;
        this.memoryLimit=memoryLimit;
        this.cfInstanceIndiex=cfInstanceIndiex;
        this.cfInstanceAddr=cfInstanceAddr;
    }
    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("PORT",this.port);
        map.put("MEMORY_LIMIT", this.memoryLimit);
        map.put("CF_INSTANCE_INDEX", this.cfInstanceIndiex);
        map.put("CF_INSTANCE_ADDR", this.cfInstanceAddr);
        return map;
    }
}
