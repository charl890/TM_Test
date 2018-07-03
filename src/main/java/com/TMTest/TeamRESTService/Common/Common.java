package com.TMTest.TeamRESTService.Common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TMTest.TeamRESTService.Controller.TeamRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Common {

	public static final Logger logger = LoggerFactory.getLogger(TeamRestService.class);

	public static String LoadCSVFile(String csvFile) throws IOException {

	BufferedReader reader = Files.newBufferedReader(Paths.get(csvFile));

	CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("TEAM_ID").withIgnoreHeaderCase().withTrim());

	for(CSVRecord csvRecord:csvParser)
	{
		// Accessing Values by Column Index

		String team_id = csvRecord.get(0);

		// Accessing the values by column header name

		// String team_idteam_id = csvRecord.get("Team_ID");

		// Printing the record

		logger.info("Record Number - " + csvRecord.getRecordNumber());

		logger.info("Team_ID : " + team_id);

	}
	ObjectMapper mapper = new ObjectMapper();

	mapper.enable(SerializationFeature.INDENT_OUTPUT);

		String json = mapper.writeValueAsString(csvParser.getRecords());
		return json;
	}
}
