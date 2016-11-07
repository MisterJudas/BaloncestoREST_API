package com.eduardobenavides.service;

import com.eduardobenavides.domain.Player;
import com.eduardobenavides.repository.PlayerRepository;
import com.eduardobenavides.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Amilcar on 10/10/2016.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public void testPlayers(){

        Player player1 = new Player("Lebron","James",26649, 2333, 23221, "Pivot");
        playerRepository.save(player1);

        Player player2 = new Player("Kevin","Durant",7563, 2059, 8806, "Alero");
        playerRepository.save(player2);

        Player player3 = new Player("Anthony","Davis",2266, 8768, 6678, "Pivot");
        playerRepository.save(player3);

        Player player4 = new Player("Stephen","Curry",11088, 6678, 23221, "Base");
        playerRepository.save(player4);

        Player player5 = new Player("James","Harden",8904, 3556, 8768, "Bsae");
        playerRepository.save(player5);

        Player player6 = new Player("Kevin","Love",9442, 87688, 36757, "Pivot");
        playerRepository.save(player6);

        Player player7 = new Player("Kyrie","Irving",6458, 8766, 8766, "Base");
        playerRepository.save(player7);

        System.out.println("");
        System.out.println("Players with position equals Base");
        System.out.println(playerRepository.findByPositionEquals("Base"));


        System.out.println("");
        System.out.println("Player with name Lebron");
        System.out.println(playerRepository.findByName("Lebron"));

        System.out.println("--1--");
        System.out.println("Players order by points");
        System.out.println(playerRepository.findByOrderByPointsDesc());

        System.out.println("--2--");
        System.out.println("Players with greater or equal than 5.000 points");
        System.out.println(playerRepository.findByPointsGreaterThan(5000));

        System.out.println("--3--");
        System.out.println("Players with points between 5000 and 10000");
        System.out.println(playerRepository.findByPointsBetween(5000, 10000));


    }

}
