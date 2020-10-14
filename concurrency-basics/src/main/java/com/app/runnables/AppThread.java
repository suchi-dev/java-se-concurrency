package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThread extends Thread{
	
	public void run() {
	try(BufferedReader br = new BufferedReader(new FileReader(new File("/home/suchitra/Desktop/suchitra/projects/java-se-concurrency/concurrency-basics/src/main/resources/sample.txt")))){
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(Thread.currentThread().getName() +" is processing line: "+line);
		}
		
	} catch (FileNotFoundException e) {
		Logger.getLogger(AppThread.class.getName()).log(Level.INFO, "msg");
		e.printStackTrace();
	} catch (IOException e) {
		Logger.getLogger(AppThread.class.getName()).log(Level.INFO, "msg");
		e.printStackTrace();
	}
			
		
		
	}

}
