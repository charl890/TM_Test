package com.TMTest.ThreadRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TMTest.TeamRESTService.Controller.TeamRestService;
import com.TMTest.TeamRESTService.RESTClient.RESTClient;

public class ThreadsReadCSVs implements Runnable {

	public static final Logger logger = LoggerFactory.getLogger(ThreadsReadCSVs.class);

	static int lineCount = 1;
	static int limit = 3000;
	BufferedReader CSVBufferedReader;

	public ThreadsReadCSVs() {
	} // default constructor

	public ThreadsReadCSVs(String CSVPath) throws Exception {
		File f = new File(CSVPath);
		if (!f.exists()) {
			logger.error("Invalid File Path ");
			throw new Exception("Invalid File Path " + CSVPath);
		}
		FileReader fr = null;
		try {
			fr = new FileReader(CSVPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("File Read Exception " + e.getMessage());
		}
		BufferedReader br = new BufferedReader(fr);
		this.CSVBufferedReader = br;
	}

	private synchronized void readCSV() {
		logger.info("Current thread " + Thread.currentThread().getName());
		String line;
		try {
			while ((line = CSVBufferedReader.readLine()) != null) {
				logger.info("Current thread " + Thread.currentThread().getName() + ": " + line);
				lineCount++;
				if (lineCount >= limit) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("File Read Exception " + e.getMessage());
		}
	}

	@Override
	public void run() {
		readCSV();
	}

	public void ProcessCSVFiles(String[] CSVFiles)
	{
		// ThreadsReadCSVs team_skill_csv = new ThreadsReadCSVs(new String []
		// {"resources/csv_files/" + "team_skill.csv","resources/csv_files/" +
		// "task.csv"});
		ThreadsReadCSVs team_skill_csv = null, task_csv = null;
		try {
			team_skill_csv = new ThreadsReadCSVs(CSVFiles[0]);

			task_csv = new ThreadsReadCSVs(CSVFiles[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Thread t1 = new Thread(team_skill_csv);
		t1.setName("t1");
		Thread t2 = new Thread(task_csv);
		t1.setName("t2");
		
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
