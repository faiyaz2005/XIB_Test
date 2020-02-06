package com.xib.agentservices.service;

import com.xib.agentservices.entity.Team;
import com.xib.agentservices.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;

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
}
