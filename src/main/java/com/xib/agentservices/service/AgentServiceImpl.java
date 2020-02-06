package com.xib.agentservices.service;

import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	ManagerService managerService;

	@Transactional
	@Override
	public Agent createAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Transactional
	@Override
	public Agent updateAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public Agent getAgent(Long id) {
		return agentRepository.getOne(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		agentRepository.deleteById(id);
	}

	@Override
	public Page<Agent> getList(Pageable pageable) {
		return agentRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public void attachManagerToAgent(Long id, Long idManager) {
		Agent agent = getAgent(id);

		Manager manager = managerService.getManager(idManager);

		agent.setManager(manager);
	}
}
