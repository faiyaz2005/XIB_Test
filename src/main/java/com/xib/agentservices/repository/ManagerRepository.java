package com.xib.agentservices.repository;

import com.xib.agentservices.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into MANAGER_TEAMS (MANAGER_ID, TEAM_ID) values (?1, ?2)")
    void attachManagerToTeam(Long managerId, Long teamId);

}
