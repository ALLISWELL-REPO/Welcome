package com.sreenutech.processer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sreenutech.beans.EmpBean;
import com.sreenutech.beans.TaskResult;
import com.sreenutech.beans.UserDetails;
import com.sreenutech.beans.personalBean;
import com.sreenutech.task.EmpTask;
import com.sreenutech.task.PersonalTask;

public class UserProcesser {

	public UserDetails getUser(String Uid) throws InterruptedException, ExecutionException {
		  System.out.println("enterd into Userdetails Layer");
		UserDetails user = new UserDetails();
		Set tasks = new HashSet<Callable>();
		tasks.add(new PersonalTask(Uid));
		tasks.add(new EmpTask(Uid));

		ExecutorService execute = Executors.newFixedThreadPool(2);
		List<Future<TaskResult>> futureList = execute.invokeAll(tasks);
		for (Future future : futureList) {
			TaskResult tR = (TaskResult) future.get();

			if ("pTask".equals(tR.getTaskName())) {
				personalBean pBean = (personalBean) tR.getResult();
				user.setFname(pBean.getFname());
				user.setLname(pBean.getLname());
				user.setHomeAddress(pBean.getHomeAddress());
				user.setuId(pBean.getuId());
			} else if ("eTask".equals(tR.getTaskName())) {
				EmpBean bean = (EmpBean) tR.getResult();
				user.setSalary(bean.getSalary());
				user.setOfficeAddress(bean.getOfficeAddress());

			}

		}
		 System.out.println(" exit into Userdetails Layer");
		return user;
	}

}
