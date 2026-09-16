package com.sai.pramod.SERVICE;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.pramod.MODEL.Transaction;
import com.sai.pramod.MODEL.TransactionSummary;

@Service
public class TransactionSummaryService {
	
	@Autowired
	TransactionService transactionService;
	public TransactionSummaryService(TransactionService transactionService)
	{
		this.transactionService=transactionService;
	}
	
	public TransactionSummary getSummary()
	{
		Map<String, Double> categoryWiseExpenses =new HashMap<>();
		double totalExpense=0;
		double totalIncome=0;
		double remainingBalance=0;
		for(Transaction t: transactionService.getAllTransactions())
		{
			if(t.getTransactionType().equalsIgnoreCase("EXPENSE"))
			{
				totalExpense+=t.getTransactionAmount();
				categoryWiseExpenses.put(t.getTransactionCategory(), categoryWiseExpenses.getOrDefault(t.getTransactionCategory(),0.0)+t.getTransactionAmount());
			}
			else if(t.getTransactionType().equalsIgnoreCase("INCOME"))
			{
				totalIncome+=t.getTransactionAmount();
			}
		}
		remainingBalance=totalIncome-totalExpense;
		return new TransactionSummary(totalIncome,totalExpense,remainingBalance,categoryWiseExpenses);
	}
	
}
