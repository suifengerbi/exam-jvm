package com.yintai.service;

import java.util.Calendar;
import java.util.HashMap;

import com.yintai.entity.Currency;
import com.yintai.entity.Customer;
import com.yintai.entity.Transaction;
import com.yintai.entity.TransactionStatus;
import com.yintai.entity.TransactionType;
import com.yintai.memorydb.MyDB;

public class ApplicationService {
	
	public Object createTranscation(int customerid, double amount,
			Currency currency, TransactionStatus status,TransactionType type) {
		HashMap<String,String> result = new HashMap<String, String>();
		Customer customer = MyDB.findById(customerid);
		if(customer==null){
			result.put("result", "0");//不存在该用客户
			return result;
		}
		Transaction trans = new Transaction();
		trans.setCreateTime(Calendar.getInstance().getTime());
		trans.setAmount(amount);
		trans.setCurrency(currency);
		trans.setType(type);
		trans.setStatus(status);
		trans.setCustomer(customer);
		MyDB.insertTransaction(trans);
		result.put("result", "1");
		result.put("amount", ""+trans.getAmount());
		result.put("status", ""+trans.getStatus());
		return result;
	}
	/**
	 * 创建客户
	 * @param name
	 * @return
	 */
	public Object createCustomer(String name){
		HashMap<String,String> result = new HashMap<String, String>();
		Customer c = new Customer();
		c.setCustomerName(name);
		Customer custimer = MyDB.insertCustomer(c);
		if(custimer!=null){
			result.put("result", "success");
			result.put("id",custimer.getId()+"");
		}else{
			result.put("result", "failure");
		}
		return result;
	}
	
	public Object searchTransaction(TransactionStatus status){
		return MyDB.searchByStatus(status);
	}
	
}
