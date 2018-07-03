package com.TMTest.TeamRESTService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TMTest.TeamRESTService.Model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

}
