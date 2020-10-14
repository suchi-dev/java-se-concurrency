package com.app.tests;

import com.app.runnables.AppRunnable;

public class TestAppRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Thread t1 = new Thread(new AppRunnable());
	t1.start();
		
	}

}
