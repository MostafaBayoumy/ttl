package com.ttl.repository.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ttl.model")
@EnableJpaRepositories("com.ttl.repository")
public class RepositoryTestApplication {

}