package com.xib.agentservices.config;


import com.xib.agentservices.repository.AgentRepository;
import com.xib.agentservices.repository.ManagerRepository;
import com.xib.agentservices.repository.TeamRepository;
import com.xib.agentservices.service.AgentService;
import com.xib.agentservices.service.ManagerService;
import com.xib.agentservices.service.TeamService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.xib.agentservices.*")
@EnableJpaRepositories(basePackages = { "com.xib.agentservices.*" })
public class TestConfig {

//	@Bean
//	public AgentService agentService(){
//		return Mockito.mock(AgentService.class);
//	}
//
//	@Bean
//	public TeamService teamService(){
//		return Mockito.mock(TeamService.class);
//	}
//
//	@Bean
//	public ManagerService managerService(){
//		return Mockito.mock(ManagerService.class);
//	}
//
//	@Bean
//	public AgentRepository agentRepository(){
//		return Mockito.mock(AgentRepository.class);
//	}
//
//	@Bean
//	public TeamRepository teamRepository(){
//		return Mockito.mock(TeamRepository.class);
//	}
//
//	@Bean
//	public ManagerRepository managerRepository(){
//		return Mockito.mock(ManagerRepository.class);
//	}

}
