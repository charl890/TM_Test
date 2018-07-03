package com.TMTest.TeamRESTService.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.TMTest.TeamRESTService.Common.Common;
import com.TMTest.TeamRESTService.Model.Team;
import com.TMTest.TeamRESTService.Service.ITeamService;
import com.TMTest.ThreadRead.ThreadsReadCSVs;

@RestController
@RequestMapping("/api")
public class TeamRestService {

	public static final Logger logger = LoggerFactory.getLogger(TeamRestService.class);

	@Autowired
	ITeamService teamService; // Service which will do all data retrieval/manipulation work

	// -------------------Create a Team----------------------------
	@PostMapping("/Team")
	public ResponseEntity<?> createStaff(@RequestBody List<Team> teamList, UriComponentsBuilder ucBuilder) {

		for (Team t : teamList)
			logger.info("Creating Team : {}", t);
		teamService.AddTeamList(teamList);
		
		ThreadsReadCSVs team_skill_csv = new ThreadsReadCSVs();
		team_skill_csv.ProcessCSVFiles(new String[]
				{"resources/csv_files/" + "team_skill.csv","resources/csv_files/" +
				"task.csv"});

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
