package com.eduardobenavides.controller;

import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Team;
import com.eduardobenavides.repository.PlayerRepository;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Amilcar on 24/10/2016.
 */

@RestController
@RequestMapping ("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping
    public List<Player> getAllPlayer(){
        List<Player> players = new ArrayList<Player>();
        Iterator<Player> iterator = playerRepository.findAll().iterator();
        while(iterator.hasNext()){
            players.add(iterator.next());
        }
        return players;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletePlayerID(@PathVariable Long id){
        Player player = playerRepository.findOne(id);
        if(player != null) playerRepository.delete(id);
    }

    // PUT
    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    // GET 1 PLAYER
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerID(@PathVariable Long id){
        Player player = playerRepository.findOne(id);
        return Optional.ofNullable(player)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<Player>(HttpStatus.NOT_FOUND));
    }


    //Numero 1
    @GetMapping("/OrderByPoints")
    public List<Player> findAllOrderByPoints() {
        return playerRepository.findByOrderByPointsDesc();
    }

    //Numero 2
    @GetMapping("/byPoints/{num}")
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num) {
        return playerRepository.findByPointsGreaterThan(num);
    }

    //Numero 3
    @GetMapping("/between/{points1}/{points2}")
    public List<Player>findByPointsBetween(@PathVariable Integer points1, @PathVariable Integer points2){
        return playerRepository.findByPointsBetween(points1, points2);
    }


    // GET --> AVG BASKETS, ASSISTS, REBOUND FROM ALL PLAYERS SAME POSITION 4
    @GetMapping("/byPosition")
    public Map<Position, Statistic> groupByPosition(){
        List<Object[]> players = playerRepository.groupByPosition();

        Map<Position, Statistic> posis = new HashMap<>();

        for (Object[] p: players) {
            Statistic aux = new Statistic((Position) p[0], (double) p[1], (int) p[2], (int) p[3]);
            posis.put(aux.getPosition(), aux);
        }
        return posis;
    }

    // GET --> SHOW ALL THE PLAYERS WITH THE SAME POSITION ORDERED BY BASKETS 5
    @GetMapping("/playersByPositionBaskets")
    public Map<Position, Collection<Player>> playersByPositionBaskets(){
        List<Player> players = playerRepository.playersByPositionBaskets();

        ListMultimap<Position, Player> playerMultiMap = ArrayListMultimap.create();

        for(Player p: players){
            playerMultiMap.put(p.getPosition(), p);
        }

        return playerMultiMap.asMap();
    }



}

