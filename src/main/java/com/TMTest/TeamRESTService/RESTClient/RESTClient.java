package com.TMTest.TeamRESTService.RESTClient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.TMTest.TeamRESTService.Common.Common;

public class RESTClient {

	private static final Logger log = LoggerFactory.getLogger(RESTClient.class);

	/*
	 * teamCSVFile : "resources/csv_files/" + "team.csv"
	 */
	public static void LoadTeam(String teamCSVFile) throws IOException {

		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	     headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	      
	     RestTemplate restTemplate = new RestTemplate();
	     String jsondata = Common.LoadCSVFile(teamCSVFile);
		restTemplate.postForLocation("http://localhost:8080/api/Team", jsondata);
	     
		log.info(jsondata.toString());
		File file = new File(teamCSVFile);
		if(file.delete()){
			log.info(file.getName() + " is deleted!");
		}else{
			log.error("Delete operation is failed.");
		}
	}
}
