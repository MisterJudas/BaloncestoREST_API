package com.eduardobenavides;

import com.eduardobenavides.service.PlayerService;
import com.eduardobenavides.service.TeamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BaloncestoApplication.class, args);

		TeamService teamService = context.getBean(TeamService.class);
		PlayerService playerService = context.getBean(PlayerService.class);

		teamService.createTeams();

		playerService.createPlayers();
		playerService.testPlayers();

		//teamService.testTeam();

	}
}
