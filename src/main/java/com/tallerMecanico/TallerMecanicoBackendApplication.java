package com.tallerMecanico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TallerMecanicoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerMecanicoBackendApplication.class, args);
	}

}
