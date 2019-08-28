package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

 @Bean
 public TimeEntryRepository getTimeEntryRepo(){
    return new InMemoryTimeEntryRepository();
 }

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}