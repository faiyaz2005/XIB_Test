package com.xib.agentservices.repository;

import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {
}
