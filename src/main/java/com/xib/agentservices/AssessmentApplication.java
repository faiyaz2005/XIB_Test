package com.xib.agentservices;

import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.entity.Team;
import com.xib.agentservices.service.AgentService;
import com.xib.agentservices.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessmentApplication implements CommandLineRunner {

	@Autowired
	TeamService teamService;

	@Autowired
	AgentService agentService;

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Init test data
		Team teamMarvel = teamService.createTeam(new Team("Marvel"));
		Team teamDC = teamService.createTeam(new Team("DC"));

		agentService.createAgent(new Agent("Bruce", "Banner", "1011125190081", teamMarvel));
		agentService.createAgent(new Agent("Tony", "Stark", "6912115191083", teamMarvel));
		agentService.createAgent(new Agent("Peter", "Parker", "7801115190084", teamMarvel));
		agentService.createAgent(new Agent("Bruce", "Wayne", "6511185190085", teamDC));
		agentService.createAgent(new Agent("Clark", "Kent", "5905115190086",teamDC));
	}
}
