package com.eduardobenavides;

import com.eduardobenavides.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(BaloncestoApplication.class, args);
		PlayerService playerService=context.getBean(PlayerService.class);

		playerService.testPlayers();

	}
}
