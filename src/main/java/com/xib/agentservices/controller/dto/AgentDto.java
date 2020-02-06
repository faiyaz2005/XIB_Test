package com.xib.agentservices.controller.dto;

import java.util.List;

public class AgentDto extends BaseDto {

	private String firstName;

	private String lastName;

	private String idNumber;

	private List<TeamDto> teams;

	public String getFirstName() {
		return firstName;
	}

	public List<TeamDto> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamDto> teams) {
		this.teams = teams;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}
