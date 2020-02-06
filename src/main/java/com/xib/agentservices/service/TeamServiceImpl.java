package com.xib.agentservices.service;

import com.xib.agentservices.entity.Agent;
import com.xib.agentservices.entity.Team;
import com.xib.agentservices.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	AgentService agentService;

	@Autowired
	ManagerService managerService;

	@Transactional
	@Override
	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}

	@Transactional
	@Override
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team getTeam(Long id) {
		return teamRepository.getOne(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		teamRepository.deleteById(id);
	}

	@Override
	public Page<Team> getList(Pageable pageable) {
		return teamRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public void attachAgentToTeam(Long id, Long agentId) throws Exception {
		Agent agent = agentService.getAgent(agentId);

		if(agent.getManager() == null)
			throw new Exception("Attach agent to manager before");

		Team team = getTeam(id);

		if(team.getManagers().stream().noneMatch(manager -> manager.getId().equals(agent.getManager().getId()))){
			throw new Exception("No agent's manager in this team");
		}

		agent.setTeam(team);

		agentService.updateAgent(agent);
	}

	@Transactional
	@Override
	public void attachManagerToTeam(Long id, Long idManager) throws Exception {
		Team team = getTeam(id);
		if(team.getManagers().size() >=2){
			throw new Exception("Team already has 2 managers");
		}

		managerService.attachManagerToTeam(idManager, team.getId());
	}

	@Override
	public List<Team> getListEmpty() {
		List<Team> teams = teamRepository.findAll();

		return teams.stream().
				filter(team -> team.getManagers().isEmpty() && team.getAgents().isEmpty()).collect(Collectors.toList());
	}
}
