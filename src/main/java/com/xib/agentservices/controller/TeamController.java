package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.BaseDto;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

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

    // ?page=0&size=20
    @GetMapping("teams")
    public ResponseEntity<Page> getTeams(@ApiIgnore Pageable pageable){
        Page<Team> teams = teamService.getList(pageable);

        return ResponseEntity.ok(new PageImpl<>(teamMapper.teamsToDtoList(teams.getContent()), pageable, teams.getTotalElements()));
    }

    @GetMapping("teams/empty")
    public ResponseEntity<List<TeamDto>> getTeams(){
        List<Team> teams = teamService.getListEmpty();

        return ResponseEntity.ok(teamMapper.teamsToDtoList(teams));
    }

    @PostMapping("team")
    public ResponseEntity<TeamDto> createTeam(@Valid @RequestBody TeamDto team){
        return ResponseEntity.ok(teamMapper.teamToDto(teamService.createTeam(teamMapper.dtoToTeam(team))));
    }

    @PutMapping("team/{id}/agent")
    public void attachAgentToTeam(@PathVariable("id") Long id, @RequestBody BaseDto idDto) throws Exception {
        teamService.attachAgentToTeam(id, idDto.getId());
    }

    @PutMapping("team/{id}/manager")
    public void attachManagerToTeam(@PathVariable("id") Long id, @RequestBody BaseDto idDto) throws Exception {
        teamService.attachManagerToTeam(id, idDto.getId());
    }

}
