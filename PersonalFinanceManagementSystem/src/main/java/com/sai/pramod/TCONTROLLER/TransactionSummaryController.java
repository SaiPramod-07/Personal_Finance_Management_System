package com.sai.pramod.TCONTROLLER;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.pramod.MODEL.TransactionSummary;
import com.sai.pramod.SERVICE.TransactionSummaryService;

@RestController
public class TransactionSummaryController {
	
	TransactionSummaryService transactionSummaryService;
	public TransactionSummaryController(TransactionSummaryService transactionSummaryService)
	{
		this.transactionSummaryService=transactionSummaryService;
	}
	
	@GetMapping("/transactions/summary")
	public TransactionSummary getSummary()
	{
		return transactionSummaryService.getSummary();
	}
}
