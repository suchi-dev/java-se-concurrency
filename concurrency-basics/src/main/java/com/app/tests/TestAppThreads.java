package com.app.tests;

import com.app.runnables.AppThread;

public class TestAppThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	AppThread t1 = new  AppThread();
	AppThread t2 = new  AppThread();
	AppThread t3 = new  AppThread();
	
	t1.start();
	t2.start();
	t3.start();
		
	}

}
