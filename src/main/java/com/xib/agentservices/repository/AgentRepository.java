package com.xib.agentservices.repository;

import com.xib.agentservices.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
