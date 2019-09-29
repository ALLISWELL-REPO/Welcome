package com.citybank.test;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementdtls.schema.res.TransDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

public class Test {
	static TransDetailsType transDetails= new TransDetailsType();
	static List<TransactionType> tranList=transDetails.getTransaction();
	

	public static void main(String[] args) {

		
		//TransList---1
		TransactionType trans1=new TransactionType();
		trans1.setId("111");
		trans1.setName("AAA");
		trans1.setAmount("10000");
		trans1.setDesc("good");
		trans1.setMerchantname("Amozon");
		trans1.setStatus("success");
		trans1.setRemark("NA");
		
		//TransList---2
		TransactionType trans2=new TransactionType();
		trans2.setId("222");
		trans2.setName("BBB");
		trans2.setAmount("20000");
		trans2.setDesc("good");
		trans2.setMerchantname("Reliance");
		trans2.setStatus("success");
		trans2.setRemark("NA");
		
		
		//TransList---5
		TransactionType trans5=new TransactionType();
		trans5.setId("555");
		trans5.setName("EEE");
		trans5.setAmount("50000");
		trans5.setDesc("good");
		trans5.setMerchantname("Flipkart2");
		trans5.setStatus("success");
		trans5.setRemark("NA");
		
		//TransList--3
		TransactionType trans3=new TransactionType();
		trans3.setId("333");
		trans3.setName("CCC");
		trans3.setAmount("30000");
		trans3.setDesc("good");
		trans3.setMerchantname("Myntra");
		trans3.setStatus("success");
		trans3.setRemark("NA");
		
		//TransList---4
		TransactionType trans4=new TransactionType();
		trans4.setId("444");
		trans4.setName("DDD");
		trans4.setAmount("40000");
		trans4.setDesc("good");
		trans4.setMerchantname("Flipkart");
		trans4.setStatus("success");
		trans4.setRemark("NA");
	
		
		 tranList.add(trans1);
		 tranList.add(trans2);
		 tranList.add(trans3);
		 tranList.add(trans4);
		 tranList.add(trans5);
		 
		 System.out.println("TransList:" +tranList.size());
		
	
		/* case1:
		Collections.sort((List<TransactionType>) tranList);
		for(TransactionType transType:tranList){
		System.out.println( transType);*/
		 
		/* case2:
		 Iterator itr=tranList.iterator();
		while(itr.hasNext()){
			Object o1=itr.next();
			TransactionType t2=(TransactionType)o1;
			System.out.println("Status="+t2.getStatus());*/
		 
		 //case3:
		/* int startIndex=2;
		 int endIndex=5;
		// List<TransactionType> l1=new ArrayList();
		for(int i=startIndex;i<endIndex;i++){
			if(startIndex>=0){
				if(i<tranList.size()){
					System.out.println( tranList.get(i));
				}
			}
		
		}*/
		
		getTotalAmountSpend();
		
	}
	
	 public static void getTotalAmountSpend(){
		 float amount=0;
		 for(TransactionType transn : tranList ){
			 float f=Float.parseFloat(transn.getAmount());
			 amount=amount + f;
		 }
		 System.out.println("Total amount ="+amount);
	 }

	 public static void getTotalAmountBasedIndex(int startIndex,int endIndex){
	
		 String amount=null;
		 if(startIndex>=0){
			 for (int i=startIndex;i<=endIndex;i++){
				 
				 if(i < tranList.size()){
					 TransactionType transn1 = null;
					float f=Float.parseFloat(transn1.getAmount());
					 amount=amount+tranList.get(i).getAmount();
				 }
			 }
		 }
	 }

}
