package com.xib.agentservices.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TeamPageDto {

	private String name;

	private List<ManagerDto> managers;

	private List<AgentDto> agents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ManagerDto> getManagers() {
		return managers;
	}

	public void setManagers(List<ManagerDto> managers) {
		this.managers = managers;
	}

	public List<AgentDto> getAgents() {
		return agents;
	}

	public void setAgents(List<AgentDto> agents) {
		this.agents = agents;
	}
}
