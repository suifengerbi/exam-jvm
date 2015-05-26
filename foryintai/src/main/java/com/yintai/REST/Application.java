package com.yintai.REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yintai.entity.Currency;
import com.yintai.entity.TransactionStatus;
import com.yintai.entity.TransactionType;
import com.yintai.service.ApplicationService;

@Controller
@EnableAutoConfiguration
public class Application {
	ApplicationService appService = new ApplicationService();
	public Application() {
		appService = new ApplicationService();
	}
	
	@ResponseBody
	@RequestMapping(value="createTranscation",method=RequestMethod.POST)
	public Object createTransactionNoPay(
			@RequestParam int customerid,
			@RequestParam double amount,
			@RequestParam Currency currency,
			@RequestParam TransactionStatus status,
			@RequestParam TransactionType type){
		return appService.createTranscation(customerid, amount, currency, status, type);
	}
	
	@ResponseBody
	@RequestMapping(value="createCustomer",method=RequestMethod.POST)
	public Object createCustomer(@RequestParam String name){
		return appService.createCustomer(name);
	}
	
	@ResponseBody
	@RequestMapping(value="searchTransaction",method=RequestMethod.POST)
	public Object searchTransaction(TransactionStatus status){
		return appService.searchTransaction(status);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
