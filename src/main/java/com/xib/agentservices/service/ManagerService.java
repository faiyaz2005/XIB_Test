package com.xib.agentservices.service;

import com.xib.agentservices.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {

	Manager createManager(Manager manager);

	Manager updateManager(Manager manager);

	Manager getManager(Long id);

	void deleteById(Long id);

	void attachManagerToTeam(Long managerId, Long teamId);

	Page<Manager> getList(Pageable pageable);
}
