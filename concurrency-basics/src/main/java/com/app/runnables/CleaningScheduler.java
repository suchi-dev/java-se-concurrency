package com.app.runnables;

import java.io.File;

public class CleaningScheduler implements Runnable{

	@Override
	public void run() {
		File folder = new File("/home/suchitra/Downloads/apache-tomcat-9.0.7/logs");
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File[] files = folder.listFiles();
		for(File file : files) {
			if(System.currentTimeMillis() - file.lastModified() > 5*60*1000) {
				System.out.println("Deleting this file : "+file.getName());
				//file.delete();
			}
		}
		
		
	}
}
