package org.sample.park.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"org.sample.park.model"})
@EnableFeignClients(basePackages = "org.sample.park.client")
@EnableJpaRepositories(basePackages = "org.sample.park.repository")
@ComponentScan(basePackages = "org.sample.park")
public class CarParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }
}
