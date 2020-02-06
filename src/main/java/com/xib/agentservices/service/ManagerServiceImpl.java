package com.xib.agentservices.service;

import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;

	@Transactional
	@Override
	public Manager createManager(Manager agent) {
		return managerRepository.save(agent);
	}

	@Transactional
	@Override
	public Manager updateManager(Manager agent) {
		return managerRepository.save(agent);
	}

	@Override
	public Manager getManager(Long id) {
		return managerRepository.getOne(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		managerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void attachManagerToTeam(Long managerId, Long teamId) {
		managerRepository.attachManagerToTeam(managerId, teamId);
	}

	@Override
	public Page<Manager> getList(Pageable pageable) {
		return managerRepository.findAll(pageable);
	}
}
