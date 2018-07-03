package com.TMTest.TeamRESTService;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.TMTest.TeamRESTService.Controller.TeamRestService;
import com.TMTest.TeamRESTService.Model.Team;
import com.TMTest.TeamRESTService.RESTClient.RESTClient;
import com.TMTest.TeamRESTService.Repository.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamRestServiceApplicationTests {

	public static final Logger logger = LoggerFactory.getLogger(TeamRestService.class);

	@Autowired
	private TeamRepository teamRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLoadFile() {
		try {
			RESTClient.LoadTeam("resources/csv_files/" + "team.csv");

			for (Team t : teamRepository.findAll()) {
				logger.info("Team data in DB : " + t);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
