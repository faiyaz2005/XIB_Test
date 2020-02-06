package com.xib.agentservices.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Agent> agents = new HashSet<>();

    @ManyToMany(mappedBy = "teams")
    private Set<Manager> managers = new HashSet<>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Set<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Set<Agent> agents) {
        this.agents = agents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }
}
