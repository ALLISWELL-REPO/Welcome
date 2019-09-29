package com.sreenutech.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sreenutech.beans.EmpBean;
import com.sreenutech.beans.PersonalBean;
import com.sreenutech.beans.UserDetails;
import com.sreenutech.tasks.EmpTask;
import com.sreenutech.tasks.PersonalTask;

public class UserDetailsProcessor {
	TaskResult tr=null;
	UserDetails udetails=new UserDetails();
	
	public UserDetails getUser(String uid) throws InterruptedException, ExecutionException
	{
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Set tasks=new HashSet<Callable>();
		tasks.add(new PersonalTask(uid));
		tasks.add(new EmpTask(uid));
		List<Future<TaskResult>> futureList = executor.invokeAll(tasks);
		for(Future future:futureList )
		{
		 tr=(TaskResult) future.get();
		
		if("pTask".equals(tr.getTaskName()))
		{
			PersonalBean pbean=(PersonalBean) tr.getResult();
			udetails.setHomeAddress(pbean.getHomeAddress());
			udetails.setMobile(pbean.getMobile());
			udetails.setName(pbean.getName());
		}
		else if("eTask".equals(tr.getTaskName()))
		{
			EmpBean ebean=(EmpBean) tr.getResult();
			udetails.setEmpName(ebean.getEmpName());
			udetails.setOfficeAddress(ebean.getOfficeAddress());
			udetails.setSalary(ebean.getSalary());
		}
		}
		return udetails;
	}
	

}
