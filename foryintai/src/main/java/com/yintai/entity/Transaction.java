package com.yintai.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易信息
 * @author mabixiang
 *
 */
public class Transaction{
	private int id;//交易 ID
	private Date createTime;//创建时间
	private TransactionStatus status;//交易状态（例如是否交易成功）
	private TransactionType type;//交易类型（例如支付还是退款）
	private double amount;//交易金额
	private Currency currency;//交易币种（例如美元还是人民币）
	private Customer customer;//客户信息
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public int hashCode() {
		return customer.hashCode()+id+createTime.hashCode();
	}
}
