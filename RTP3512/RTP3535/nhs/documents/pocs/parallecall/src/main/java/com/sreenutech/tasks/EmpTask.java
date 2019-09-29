package com.sreenutech.tasks;

import java.util.concurrent.Callable;

import com.sreenutech.beans.EmpBean;
import com.sreenutech.processor.TaskResult;

public class EmpTask implements Callable<TaskResult> {

	private String uid;

	public EmpTask(String uid) {
		this.uid = uid;
	}

	public TaskResult call() throws Exception {
		//prepare Dao req
		// call db and get the resp
		EmpBean ebean=new EmpBean();
		ebean.setOfficeAddress("hyd");
		ebean.setSalary(12425);
		ebean.setEmpName("tech");
		TaskResult task=new TaskResult();
		task.setTaskName("eTask");
		task.setResult(ebean);

		return task;
	}

}
