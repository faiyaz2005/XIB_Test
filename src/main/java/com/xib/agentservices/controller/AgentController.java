package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.AgentDto;
import com.xib.agentservices.controller.dto.BaseDto;
import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.filter.AgentManagerFilter;
import com.xib.agentservices.mapper.AgentMapper;
import com.xib.agentservices.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentMapper agentMapper;

    @GetMapping("agent/{id}")
    public ResponseEntity<AgentDto> findAgent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(agentMapper.agentToDto(agentService.getAgent(id)));
    }

    // ?page=0&size=20
    @GetMapping("agents/pagination")
    public ResponseEntity<Page> getAgents(@ApiIgnore @PageableDefault(size = 5)  Pageable pageable, @ModelAttribute AgentManagerFilter filter){
        Page<Agent> agents = agentService.getListPage(pageable, filter);

        return ResponseEntity.ok(new PageImpl<>(agentMapper.agentsPageToDtoList(agents.getContent()), pageable, agents.getTotalElements()));
    }

    @GetMapping("agents")
    public ResponseEntity getAgents(){
        List<Agent> agents = agentService.getList();

        return ResponseEntity.ok(agentMapper.agentsToDtoList(agents));
    }

    @PostMapping("agent")
    public ResponseEntity<AgentDto> createAgent(@Valid @RequestBody AgentDto agentDto){
        return ResponseEntity.ok(agentMapper.agentToDto(agentService.createAgent(agentMapper.dtoToAgent(agentDto))));
    }

    @PutMapping("agent/{id}/manager")
    public void attachManagerToAgent(@PathVariable("id") Long id, @RequestBody BaseDto idDto) throws Exception {
        agentService.attachManagerToAgent(id, idDto.getId());
    }

}
