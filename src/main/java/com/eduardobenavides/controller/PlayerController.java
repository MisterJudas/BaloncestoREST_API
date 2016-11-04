package com.eduardobenavides.controller;

import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Team;
import com.eduardobenavides.repository.PlayerRepository;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Amilcar on 24/10/2016.
 */

@RestController
@RequestMapping ("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public Player findById(@PathVariable Long id) {
        Player player = playerRepository.findOne(id);
        return player;
    }

    @GetMapping("/byPoints/{num}")
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num) {
        return playerRepository.findByPointsGreaterThan(num);
    }

    //Devolver todos los jugadores ordenados por número de canastas.
    @RequestMapping(method = RequestMethod.GET)
    public List<Player> findAll() {
        return playerRepository.findByOrderByPointsDesc();
    }


    //Devolver todos los jugadores que han conseguido un número de canastas en un rango
    // determinado (mínimo y máximo).
    /*@RequestMapping(value = "/byPointsBetween/{num, num}",
            method = RequestMethod.GET)
    public List<Player> findByPointsBetween(){
        return playerRepository.findByPointsBetween(num, num);
    }*/
/*
    @RequestMapping(value = "/byPointsBetween/{num-num}")
    public List<Player> findByPointsBetween(@PathVariable Integer num){
        return playerRepository.findByPointsBetween(num, num);
    }*/

    //Devolver los jugadores agrupados por posición mediante un Map.
    @RequestMapping(value = "/byPosition/{position}")
    public List<Player> findByPositionEquals(@PathVariable String position){
        return playerRepository.findByPositionEquals(position);
    }






   /* @RequestMapping(method = RequestMethod.GET)
    public List<Team>findAll(){
        List<Team> teams = new ArrayList<Team>();
        Iterator<Team> iterator = teamRepository.findAll().iterator();
        while(iterator.hasNext()){
            team.add(iterator.next());
        }
        return teams;
    }*/

}

