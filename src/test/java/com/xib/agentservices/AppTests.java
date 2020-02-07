package com.xib.agentservices;


import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.entity.Team;
import com.xib.agentservices.service.AgentService;
import com.xib.agentservices.service.ManagerService;
import com.xib.agentservices.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = "com.xib.agentservices.*")
public class AppTests {

	@Autowired
	AgentService agentService;

	@Autowired
	TeamService teamService;

	@Autowired
	ManagerService managerService;

	Agent testAgentUpdate;

	Manager testManagerUpdate;

	Team emptyTeam;

	@BeforeEach
	public void setup(){
		testAgentUpdate = agentService.createAgent(new Agent("test","test","test",null));
		testManagerUpdate = managerService.createManager(new Manager("test","test","test",null));

		emptyTeam = teamService.createTeam(new Team("Empty team"));
	}

	@Test
	void createAgent() {
		Agent result = agentService.createAgent(new Agent("test","test","test",null));
		assertNotNull(result.getId());
	}

	@Test
	void updateAgent(){
		Agent oldAgent = agentService.getAgent(testAgentUpdate.getId());

		oldAgent.setIdNumber("1111111111");

		agentService.updateAgent(oldAgent);

		assertEquals("1111111111", agentService.getAgent(oldAgent.getId()).getIdNumber());
	}

	@Test
	void getAgentList(){
		assertFalse(agentService.getList().isEmpty());
	}

	@Test
	void createManager() {
		Manager result = managerService.createManager(new Manager("test","test","test",null));
		assertNotNull(result.getId());
	}

	@Test
	void updateManager(){
		Manager oldManger = managerService.getManager(testManagerUpdate.getId());

		oldManger.setFirstName("1111111111");

		managerService.updateManager(oldManger);

		assertEquals("1111111111", managerService.getManager(oldManger.getId()).getFirstName());
	}

	@Test
	void getManagerList(){
		assertFalse(managerService.getList().isEmpty());
	}

	@Test
	void getEmptyTeam(){
		assertEquals(teamService.getListEmpty().size(), 1);
	}

	@Test
	void getTeamList(){
		assertFalse(managerService.getList().isEmpty());
	}

	@Test
	void createTeam() {
		Team result = teamService.createTeam(new Team("test team"));
		assertNotNull(result.getId());
	}
}
