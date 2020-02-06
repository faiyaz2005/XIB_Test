package com.xib.agentservices.mapper;

import com.xib.agentservices.controller.dto.TeamDto;
import com.xib.agentservices.entity.Team;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

	Team dtoToTeam(TeamDto teamDto);

	TeamDto teamToDto(Team team);


	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<TeamDto> teamsToDtoList(List<Team> agents);
}
