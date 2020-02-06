package com.xib.agentservices.service;

import com.xib.agentservices.entity.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgentService {

	Agent createAgent(Agent Agent);

	Agent updateAgent(Agent Agent);

	Agent getAgent(Long id);

	void deleteById(Long id);

	Page<Agent> getList(Pageable pageable);

    void attachManagerToAgent(Long id, Long idManager);
}
