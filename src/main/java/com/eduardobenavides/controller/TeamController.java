package com.eduardobenavides.controller;

import com.eduardobenavides.controller.util.HeaderUtil;
import com.eduardobenavides.domain.Player;
import com.eduardobenavides.domain.Team;
import com.eduardobenavides.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static sun.audio.AudioPlayer.player;

/**
 * Created by 48092788H on 28/10/2016.
 */

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Team> createTeam(@RequestBody Team team) throws URISyntaxException {
        if (team.getId() != null) {
            return ResponseEntity.
                    badRequest().
                    headers(
                            HeaderUtil.
                                    createFailureAlert("team", "idexists", "A new team cannot already have an ID")).body(null);
        }
        Team result = teamRepository.save(team);
        return ResponseEntity.created(new URI("/teams/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("team", result.getId().toString()))
                .body(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id){
        Team team = teamRepository.findOne(id);
        if (team!=null){
            return new ResponseEntity<Team>(team,HttpStatus.OK);
        }else{
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

    // T0D0 Gestión de errores cuando el parametro de ordenación es invalido.
    @GetMapping
    public List<Team> findAllOrderBy(
            @RequestParam(
                    name = "orderBy", required = false) String orderBy,
            @RequestParam(
                    name = "direction",defaultValue = "ASC") String direction
    ){
        if(orderBy != null) {
            Sort sort;
            if (direction.equals("ASC")){
                sort = new Sort(Sort.Direction.ASC, orderBy);
            }
            else{
                sort = new Sort(Sort.Direction.DESC, orderBy);
            }
            return teamRepository.findAll(sort);
        }
        return teamRepository.findAll();
    }




}
