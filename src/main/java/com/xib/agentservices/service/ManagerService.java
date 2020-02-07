package com.xib.agentservices.service;

import com.xib.agentservices.entity.Manager;
import com.xib.agentservices.filter.AgentManagerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManagerService {

	Manager createManager(Manager manager);

	Manager updateManager(Manager manager);

	Manager getManager(Long id);

	void deleteById(Long id);

	void attachManagerToTeam(Long managerId, Long teamId);

	Page<Manager> getListPage(Pageable pageable, AgentManagerFilter filter);

	List<Manager> getList();
}
