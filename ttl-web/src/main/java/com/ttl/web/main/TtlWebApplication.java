package com.ttl.web.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ttl"})
@EntityScan("com.ttl.model")
@EnableJpaRepositories("com.ttl.repository")
public class TtlWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtlWebApplication.class, args);
	}

}
