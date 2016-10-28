package com.eduardobenavides.controller;

import com.eduardobenavides.domain.Team;
import com.eduardobenavides.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 48092788H on 28/10/2016.
 */

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team){ return teamRepository.save(team);}

    @RequestMapping(method = RequestMethod.GET)
    public List<Team> findAll(){ return teamRepository.findAll();}

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET)
    public Team findById(@PathVariable Long id){
        Team team = teamRepository.findOne(id);
    return team;
    }

}
