package com.sreenutech.tasks;

import java.util.concurrent.Callable;

import com.sreenutech.beans.PersonalBean;
import com.sreenutech.processor.TaskResult;

public class PersonalTask implements Callable<TaskResult> {

	private String uid;

public	PersonalTask(String uid) {
		this.uid = uid;
	}

	public TaskResult call() throws Exception {
		//prepare Dao req
		// call db and get the resp
		PersonalBean pbean=new PersonalBean();
		pbean.setHomeAddress("hyd");
		pbean.setMobile("12425");
		pbean.setName("sreenu");
		TaskResult task=new TaskResult();
		task.setTaskName("pTask");
		task.setResult(pbean);

		return task;
	}


}
