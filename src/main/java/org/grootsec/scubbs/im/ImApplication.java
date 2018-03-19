package org.grootsec.scubbs.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class ImApplication {
    @RequestMapping("/")
    String index() {
        return "IM Core of SCUBBS";
    }

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }
}
