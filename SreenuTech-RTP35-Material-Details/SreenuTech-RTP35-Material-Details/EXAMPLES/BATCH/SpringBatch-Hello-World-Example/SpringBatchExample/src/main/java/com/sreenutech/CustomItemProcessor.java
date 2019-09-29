package com.sreenutech;

import org.springframework.batch.item.ItemProcessor;

import com.sreenutech.model.Report;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		System.out.println("Processing..." + item.getId());
		
		//Case 1 : 1. if the staffName is sreen dont process the record
		if( item.getStaffName() .equals("sreenu") ){
			//---skip the records
			
		}
		
		//1. Prepare the req for rest service
		//2. create Http Request object
		//set headers contenttype,accept,methods
		//invoke the rest service
		return item;
	}

}