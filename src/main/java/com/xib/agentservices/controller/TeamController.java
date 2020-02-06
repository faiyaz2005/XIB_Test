package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.TeamDto;
import com.xib.agentservices.entity.Team;
import com.xib.agentservices.mapper.TeamMapper;
import com.xib.agentservices.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    TeamMapper teamMapper;

    @GetMapping("team/{id}")
    public ResponseEntity<TeamDto> findTeam(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teamMapper.teamToDto(teamService.getTeam(id)));
    }

    @GetMapping("teams")
    public ResponseEntity<Page> getTeams(Pageable pageable){
        Page<Team> teams = teamService.getList(pageable);

        return ResponseEntity.ok(new PageImpl<>(teamMapper.teamsToDtoList(teams.getContent()), pageable, teams.getTotalElements()));
    }

    @PostMapping("team")
    public ResponseEntity<TeamDto> createTeam(@Valid @RequestBody TeamDto team){
        return ResponseEntity.ok(teamMapper.teamToDto(teamService.createTeam(teamMapper.dtoToTeam(team))));
    }

}
