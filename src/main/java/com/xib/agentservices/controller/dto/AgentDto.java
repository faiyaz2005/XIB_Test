package com.xib.agentservices.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AgentDto extends BaseDto {

	private String firstName;

	private String lastName;

	private String idNumber;

	public String getFirstName() {
		return firstName;
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
