package com.eduardobenavides.controller;

import com.eduardobenavides.domain.Team;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Position;
import com.eduardobenavides.domain.Statistic;
import com.eduardobenavides.repository.PlayerRepository;

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

   /* @GetMapping
    public List<Player> getAllPlayer(){
        List<Player> players = new ArrayList<Player>();
        Iterator<Player> iterator = playerRepository.findAll().iterator();
        while(iterator.hasNext()){
            players.add(iterator.next());
        }
        return players;
    }*/

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


    // 1 - Devolver todos los jugadores ordenados por número de canastas.
    @GetMapping("/OrderByPoints")
    public List<Player> findAllOrderByPoints() {
        return playerRepository.findByOrderByPointsDesc();
    }

    // 2 - Devolver todos los jugadores que han conseguido un número de canastas igual o superior a un parámetro especificado en la URL.
    @GetMapping("/byPoints/{num}")
    public List<Player> findByPointsGreaterThan(@PathVariable Integer num) {
        return playerRepository.findByPointsGreaterThan(num);
    }

    // 3 - Devolver todos los jugadores que han conseguido un número de canastas en un rango determinado (mínimo y máximo).
    @GetMapping("/between/{points1}/{points2}")
    public List<Player>findByPointsBetween(@PathVariable Integer points1, @PathVariable Integer points2){
        return playerRepository.findByPointsBetween(points1, points2);
    }

    // 4 - Devolver los jugadores agrupados por posición mediante un Map.
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

    @GetMapping
    public List<Player> findAllOrderBy(@RequestParam(name = "orderBy", required = false) String orderBy){
        if(orderBy != null) {
            return playerRepository.findAll(new Sort(Sort.Direction.DESC, orderBy));
        }
        return playerRepository.findAll();
    }

    // 5 - Devolver los equipos agrupados por localidad mediante un Map.
   @GetMapping("/playersByPositionPoints")
    public Map<Position, Collection<Player>> playersByPositionPoints(){
        ListMultimap<Position, Player> playerMultiMap = ArrayListMultimap.create();
        playerRepository.playersByPositionPoints().forEach(
                player -> playerMultiMap.put(player.getPosition(), player)
        );
        return playerMultiMap.asMap();
    }

    // 6 - Devolver todos los jugadores ordenados por un criterio @RequestParam
    @GetMapping("/byParams")
    public List<Player> orderByParam(@RequestParam(name = "orderBy") String orderBy){
        if(orderBy != null) {
            return playerRepository.findAll(new Sort(Sort.Direction.DESC, orderBy));
        }
        return playerRepository.findAll();
    }





}

