package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.ManagerDto;
import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.filter.AgentManagerFilter;
import com.xib.agentservices.mapper.ManagerMapper;
import com.xib.agentservices.service.ManagerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @Autowired
    ManagerMapper managerMapper;

    @GetMapping("manager/{id}")
    public ResponseEntity<ManagerDto> findManager(@PathVariable("id") Long id) {
        return ResponseEntity.ok(managerMapper.managerToDto(managerService.getManager(id)));
    }

    @PostMapping("manager")
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDto) {
        return ResponseEntity.ok(managerMapper
                .managerToDto(managerService.createManager(managerMapper.dtoToManager(managerDto))));
    }

    // ?page=0&size=20
    @GetMapping("managers/pagination")
    public ResponseEntity<Page> getManagers(@ApiIgnore Pageable pageable, @ModelAttribute AgentManagerFilter filter){
        Page<Manager> manager = managerService.getListPage(pageable, filter);

        return ResponseEntity.ok(new PageImpl<>(managerMapper.managersPageToDtoList(manager.getContent()), pageable, manager.getTotalElements()));
    }

    @GetMapping("managers")
    public ResponseEntity getManagers(){
        List<Manager> managers = managerService.getList();

        return ResponseEntity.ok(managerMapper.managersToDtoList(managers));
    }

}
