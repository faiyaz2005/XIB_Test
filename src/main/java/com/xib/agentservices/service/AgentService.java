package com.xib.agentservices.service;

import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.filter.AgentManagerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AgentService {

	Agent createAgent(Agent Agent);

	Agent updateAgent(Agent Agent);

	Agent getAgent(Long id);

	void deleteById(Long id);

	Page<Agent> getListPage(Pageable pageable,  AgentManagerFilter filter);

	List<Agent> getList();

    void attachManagerToAgent(Long id, Long idManager);
}
