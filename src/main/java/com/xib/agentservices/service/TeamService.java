package com.xib.agentservices.service;


import com.xib.agentservices.entity.Team;
import com.xib.agentservices.filter.TeamFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamService {

	Team createTeam(Team team);

	Team updateTeam(Team team);

	Team getTeam(Long id);

	void deleteById(Long id);

	List<Team> getList();

	Page<Team> getListPage(Pageable pageable, TeamFilter filter);

    void attachAgentToTeam(Long id, Long idAgent) throws Exception;

	void attachManagerToTeam(Long id, Long idManager) throws Exception;

	List<Team> getListEmpty();
}
