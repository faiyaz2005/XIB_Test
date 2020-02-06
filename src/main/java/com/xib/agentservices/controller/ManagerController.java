package com.xib.agentservices.controller;

import com.xib.agentservices.controller.dto.ManagerDto;
import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.mapper.ManagerMapper;
import com.xib.agentservices.service.ManagerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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


    // ?page=0&size=20
    @GetMapping("managers")
    public ResponseEntity<Page> getManagers(@ApiIgnore Pageable pageable){
        Page<Manager> agents = managerService.getList(pageable);

        return ResponseEntity.ok(new PageImpl<>(managerMapper.managersToDtoList(agents.getContent()), pageable, agents.getTotalElements()));
    }

}
