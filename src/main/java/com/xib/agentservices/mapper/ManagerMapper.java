package com.xib.agentservices.mapper;

import com.xib.agentservices.controller.dto.ManagerDto;
import com.xib.agentservices.controller.dto.ManagerPageDto;
import com.xib.agentservices.entity.Manager;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

	Manager dtoToManager(ManagerDto managerDto);

	ManagerDto managerToDto(Manager manager);

	ManagerPageDto managerPageToDto(Manager manager);

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<ManagerDto> managersToDtoList(List<Manager> managers);

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<ManagerPageDto> managersPageToDtoList(List<Manager> managers);

}
