package com.xib.agentservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agent {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Manager manager;

    public Agent() {
    }

    public Agent(String firstName, String lastName, String idNumber, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.team = team;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
