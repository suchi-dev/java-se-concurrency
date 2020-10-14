package com.app.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.app.beans.User;
import com.app.dao.UserDao;

public class UserProcessor implements Callable<Integer> {

	private String userRecord;
	private UserDao userDao;

	public UserProcessor(String userRecord, UserDao userDao) {
		super();
		this.userRecord = userRecord;
		this.userDao = userDao;
	}

	@Override
	public Integer call() throws Exception {
		StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
		int row = 0;
		User user = null;
		while (tokenizer.hasMoreTokens()) {
			user = new User();
			user.setEmailAddress(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.valueOf(tokenizer.nextToken()));
			row = userDao.saveAllUsers(user);

		}
		return row;

	}

}
