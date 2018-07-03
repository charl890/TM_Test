package com.TMTest.TeamRESTService.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TMTest.TeamRESTService.Model.Team;
import com.TMTest.TeamRESTService.Repository.TeamRepository;

@Service("TeamService")
@Transactional
public class TeamServiceImpl implements ITeamService {

	public static final Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);

	@Autowired
	public TeamRepository teamRepository;

	@Override
	public void AddTeamList(List<Team> teamList) {
		// TODO Auto-generated method stub
		teamRepository.saveAll(teamList);
	}

}
