package com.yintai.memorydb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.yintai.entity.Customer;
import com.yintai.entity.Transaction;
import com.yintai.entity.TransactionStatus;

public class MyDB {
	private static HashSet<Customer> customers = new HashSet<Customer>();
	private static HashSet<Transaction> transactions = new HashSet<Transaction>();
	
	private static int customerCount = 0;
	private static int transactionCount = 0;
	
	public static List<Transaction> searchByStatus(TransactionStatus status){
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		for(Transaction transaction:transactions){
			if(transaction.getStatus()==status){
				list.add(transaction);
			}else if(status==null){
				list.add(transaction);
			}
		}
		return list;
	}
	
	public static Customer insertCustomer(Customer c){
		if(!customers.contains(c)){
			c.setId(++customerCount);
			customers.add(c);
			return c;
		}
		else{
			return null;
		}
	}
	
	public static int insertTransaction(Transaction t){
		if(!transactions.contains(t)){
			t.setId(++transactionCount);
			transactions.add(t);
			return 1;
		}
		else{
			return 0;
		}
	}
	/**
	 * 是否包含customer
	 * @param c
	 * @return
	 */
	public static boolean hasCustomer(Customer c){
		return customers.contains(c);
	}
	/**
	 * 是否包含该记录
	 * @param t
	 * @return
	 */
	public static boolean hasTransaction(Transaction t){
		return transactions.contains(t);
	}
	/**
	 * 查找相关id的用户
	 * @param customerid
	 * @return
	 */
	public static Customer findById(int customerid){
		for(Customer customer:customers){
			if(customer.getId()==customerid){
				return customer;
			}
		}
		return null;
	}
}
