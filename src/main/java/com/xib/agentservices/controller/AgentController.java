package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.AgentDto;
import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.mapper.AgentMapper;
import com.xib.agentservices.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("agent")
public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentMapper agentMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AgentDto> findAgent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(agentMapper.agentToDto(agentService.getAgent(id)));
    }

    @GetMapping
    public ResponseEntity<Page> getAgents(Pageable pageable){
        Page<Agent> agents = agentService.getList(pageable);

        return ResponseEntity.ok(new PageImpl<>(agentMapper.agentsToDtoList(agents.getContent()), pageable, agents.getTotalElements()));
    }

}
