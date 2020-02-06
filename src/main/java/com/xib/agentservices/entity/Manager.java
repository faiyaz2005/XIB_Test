package com.xib.agentservices.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Manager_Teams",
            joinColumns = { @JoinColumn(name = "manager_id") },
            inverseJoinColumns = { @JoinColumn(name = "team_id") }
    )
    private Set<Team> teams;

    public Manager() {
    }

    public Manager(String firstName, String lastName, String idNumber, Set<Team> teams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.teams = teams;
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

    public Set<Team> getTeam() {
        return teams;
    }

    public void setTeam(Set<Team> teams) {
        this.teams = teams;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
