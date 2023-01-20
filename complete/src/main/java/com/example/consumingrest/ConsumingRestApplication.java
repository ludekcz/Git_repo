package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ConsumingRestApplication {


	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
	@GetMapping("/api")
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);

		String url = "https://catfact.ninja/fact?max_length=100"; //https://catfact.ninja/
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://localhost:8072", Quote.class);
			log.info(quote.toString()); //Dobrý den
		};
	}
}
