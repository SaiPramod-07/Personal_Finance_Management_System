package com.sai.pramod.TCONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.pramod.MODEL.Transaction;
import com.sai.pramod.SERVICE.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	
	@Autowired
	private  TransactionService transactionService;
	public TransactionController(TransactionService ntransactionService)
	{
		this.transactionService=ntransactionService;
	}
	
	@PostMapping("/transactions")
	public String addTransaction(@Valid @RequestBody Transaction transaction) {
	    return transactionService.addTransaction(transaction);
	}
	
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
	    return transactionService.getAllTransactions();
	}
	
	@PutMapping("/transactions/{transactionId}")
	public String updateTransaction(@PathVariable int transactionId,@Valid @RequestBody Transaction transaction) {
	    return transactionService.updateTransaction(transactionId, transaction);
	}
	
	@DeleteMapping("/transactions/{transactionId}")
	public String deleteTransaction(@PathVariable int transactionId) {
	    return transactionService.deleteTransaction(transactionId);
	}
	
	@GetMapping("/transactions/filterByType/{transactionType}")
	public List<Transaction> filterByTransactionType(@PathVariable String transactionType)
	{
		if (!transactionType.equalsIgnoreCase("INCOME")
		        && !transactionType.equalsIgnoreCase("EXPENSE")) {
		    throw new IllegalArgumentException("Invalid transaction type");
		}
		return transactionService.filterByTransactionType(transactionType);
	}
}
