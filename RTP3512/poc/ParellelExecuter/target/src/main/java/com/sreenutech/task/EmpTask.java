package com.sreenutech.task;

import java.util.concurrent.Callable;

import com.sreenutech.beans.EmpBean;
import com.sreenutech.beans.TaskResult;

public class EmpTask implements Callable<TaskResult> {
	private String Uid;

	public EmpTask(String Uid) {
		this.Uid = Uid;
	}

	public TaskResult call() throws Exception {
		 System.out.println("enterd into EmpBean Layer");
		EmpBean eBean = new EmpBean();
		eBean.setSalary("100000");
		eBean.setOfficeAddress("Hitech");
		TaskResult result = new TaskResult();
		result.setTaskName("eTask");
		result.setResult(eBean);
		System.out.println(" exit into EmpBean Layer");
		return result;
	}

}
