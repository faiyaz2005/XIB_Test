package com.xib.agentservices.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TeamDto extends BaseDto {

	@NotNull
	@NotEmpty
	@NotBlank
	private String name;

	private List<ManagerDto> managers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
