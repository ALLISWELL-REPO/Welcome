package com.sreenutech.task;

import java.util.concurrent.Callable;

import com.sreenutech.beans.TaskResult;
import com.sreenutech.beans.personalBean;

public class PersonalTask  implements Callable<TaskResult>{
	
	 private String Uid;
	  
	 public PersonalTask(String Uid)
	 {
		 this.Uid=Uid;
	 }
	
	public TaskResult call() throws Exception {
		 System.out.println("enterd into PersonalTask layer");
		 personalBean bean=new personalBean();
		              bean.setFname("deepak");
		              bean.setLname("rout");
		              bean.setuId("12137sn");
		              bean.setHomeAddress("ameerpet");
		              TaskResult result=new TaskResult();
		              result.setTaskName("pTask");
		              result.setResult(bean);
	System.out.println("  exit into PersonalTask layer");
		return result;
	}

}
