package com.app.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.app.runnables.CleaningScheduler;
import com.app.runnables.LoggingProcessor;

public class TestCleaningScheduler {
	public static void main(String [] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// schedules this job after an initial delay of 5  secs
		//service.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
		
		// schedules cleaning job after every 4 seconds.The 1st instance would run after an initial delay of 5 seconds
		//service.scheduleAtFixedRate(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
		
		//schedules with a fixed delay after waiting for the previous instance to get completed.
		service.scheduleWithFixedDelay(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
		
		
		System.out.println("Main fn completed");
		
		
		
		
		
	}

}
