package com.eduardobenavides.service;

import com.eduardobenavides.domain.Position;
import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Team;
import com.eduardobenavides.repository.PlayerRepository;
import com.eduardobenavides.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by Amilcar on 10/10/2016.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public void createPlayers() {

        Team team1 = teamRepository.findOne(1L);
        Team team2 = teamRepository.findOne(2L);
        Team team3 = teamRepository.findOne(3L);
        Team team4 = teamRepository.findOne(4L);
        Team team5 = teamRepository.findOne(5L);
        Team team6 = teamRepository.findOne(6L);
        Team team7 = teamRepository.findOne(7L);

        Player player1 = new Player("Lebron", "James", LocalDate.of(1978, 10, 21), 26649, 2333, 23221, Position.Pivot, team1 );
        playerRepository.save(player1);

        Player player2 = new Player("Kevin", "Durant", LocalDate.of(1955, 1, 18), 7563, 2059, 8806, Position.Pivot, team3);
        playerRepository.save(player2);

        Player player3 = new Player("Anthony", "Davis", LocalDate.of(1988, 7, 12), 2266, 8768, 6678, Position.Pivot, team4);
        playerRepository.save(player3);

        Player player4 = new Player("Stephen", "Curry", LocalDate.of(1998, 6, 8), 11088, 6678, 23221, Position.Alero, team5);
        playerRepository.save(player4);

        Player player5 = new Player("James", "Harden", LocalDate.of(2000, 9, 7), 8904, 3556, 8768, Position.Alero, team7);
        playerRepository.save(player5);

        Player player6 = new Player("Kevin", "Love", LocalDate.of(1928, 12, 12), 9442, 87688, 36757, Position.Base, team6);
        playerRepository.save(player6);

        Player player7 = new Player("Kyrie", "Irving", LocalDate.of(1988, 3, 29), 6458, 8766, 8766, Position.Base, team2);
        playerRepository.save(player7);
    }


    public void testPlayers() {
        System.out.println("------------------------");
        System.out.println("FindByNameStartingWith D");
        System.out.println(playerRepository.findByNameStartingWith("D"));
        System.out.println("");

        System.out.println("------------------------------");
        System.out.println("FindByPointsGreaterThanEqual 4");
        System.out.println(playerRepository.findByPointsGreaterThanEqual(4));
        System.out.println("");

        System.out.println("--------------------------");
        System.out.println("FindByAssistsBetween 6, 13");
        System.out.println(playerRepository.findByAssistsBetween(6, 13));
        System.out.println("");

        System.out.println("--------------------------------");
        System.out.println("FindByBirthDateAfter 2003, 10,12");
        System.out.println(playerRepository.findByBirthDateAfter(LocalDate.of(2003, 10, 12)));
        System.out.println("");

        System.out.println("-------------------------");
        System.out.println("FindByPositionEquals Base");
        System.out.println(playerRepository.findByPositionEquals(Position.Base));
        System.out.println("");

        System.out.println("-----------------------");
        System.out.println("Player with name Lebron");
        System.out.println(playerRepository.findByName("Lebron"));
        System.out.println("");


        System.out.println("[1]--------------------");
        System.out.println("Players order by points");
        System.out.println("");
        System.out.println(playerRepository.findByOrderByPointsDesc());

        System.out.println("[2]------------------------------------------------");
        System.out.println("Players with greater or equal than url 5.000 points");
        System.out.println("");
        System.out.println(playerRepository.findByPointsGreaterThan(5000));

        System.out.println("[3]---------------------------------------");
        System.out.println("Players with points between 5000 and 10000");
        System.out.println("------------------------------------------");
        System.out.println(playerRepository.findByPointsBetween(5000, 10000));

        System.out.println("[4]--------------------------");
        System.out.println("Players order by position map");
        System.out.println("-----------------------------");
        playerRepository.findAvgOfPointsAssistsReboundByPosition().
                forEach(player -> System.out.println(player[3]+", avg baskets: "+player[0]+", avg assists: "+player[1]+", avg rebound: "+player[2]));

        System.out.println("[5]");
        System.out.println("Players order by ");


        System.out.println("[7]------------------------");
        System.out.println("Min max avg by position map");
        System.out.println("---------------------------");
        playerRepository.findAvgMinMaxOfPointsAssistsReboundByPosition().
                forEach(aux -> System.out.println(aux[0] +
                        "\nBasket statistics -> avg: "+aux[1]+", max, "+aux[2]+", min "+aux[3]+
                        "\nAssists statistics -> avg: "+aux[4]+", max, "+aux[5]+", min "+aux[6]+
                        "\nRebound statistics -> avg: "+aux[7]+", max, "+aux[8]+", min "+aux[9]));


    }
}
