package com.capella;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@Slf4j
@EnableJpaAuditing
public class ErpApplication {

	public static void main(String[] args) {
		log.info("Started ERP Application");
		SpringApplication.run(ErpApplication.class, args);
	}

}
