package com.xib.agentservices.mapper;

import com.xib.agentservices.controller.dto.AgentDto;
import com.xib.agentservices.entity.Agent;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgentMapper {

	Agent dtoToAgent(AgentDto agentDto);

	AgentDto agentToDto(Agent agent);

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<AgentDto> agentsToDtoList(List<Agent> agents);
}
