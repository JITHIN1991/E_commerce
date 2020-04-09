package com.jithin.sampleEcommerceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SampleEcommerceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleEcommerceAppApplication.class, args);
	}

}
