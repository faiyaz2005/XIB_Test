package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.BaseDto;
import com.xib.agentservices.controller.dto.TeamDto;
import com.xib.agentservices.entity.Team;
import com.xib.agentservices.filter.TeamFilter;
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

    @GetMapping("teams")
    public ResponseEntity getTeams(){
        List<Team> teams = teamService.getList();

        return ResponseEntity.ok(teamMapper.teamsToDtoList(teams));
    }

    // ?page=0&size=20
    @GetMapping("teams/pagination")
    public ResponseEntity<Page> getTeams(@ApiIgnore Pageable pageable, @ModelAttribute TeamFilter filter){
        Page<Team> teams = teamService.getListPage(pageable, filter);

        return ResponseEntity.ok(new PageImpl<>(teamMapper.teamsPageToDtoList(teams.getContent()), pageable, teams.getTotalElements()));
    }

    @GetMapping("teams/empty")
    public ResponseEntity<List<TeamDto>> getTeamsEmpty(){
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
