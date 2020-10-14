package com.app.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;

public class TestCallable {

	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();
		List<String> users = readFile(
				"/home/suchitra/Desktop/suchitra/projects/java-se-concurrency/concurrency-basics/src/main/resources/db.txt");
		UserDao userDao = new UserDao();
		for (String user : users) {
			Future<Integer> future = service.submit(new UserProcessor(user, userDao));
			try {
				System.out.println("Result of the operation : "+future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();
		System.out.println("Main execution is completed");
		
		

	}

	public static List<String> readFile(String fileName) {

		List<String> userRecords = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				userRecords.add(line);
			}

		} catch (FileNotFoundException e) {
			Logger.getLogger(TestCallable.class.getName()).log(Level.INFO, "msg");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.getLogger(TestCallable.class.getName()).log(Level.INFO, "msg");
			e.printStackTrace();
		}
		return userRecords;
	}

}
