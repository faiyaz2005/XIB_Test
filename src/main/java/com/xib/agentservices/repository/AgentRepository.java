package com.xib.agentservices.repository;

import com.xib.agentservices.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgentRepository extends JpaRepository<Agent, Long>, JpaSpecificationExecutor<Agent> {

}
