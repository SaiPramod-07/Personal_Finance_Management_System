package com.sai.pramod.SERVICE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sai.pramod.MODEL.Transaction;


@Service
public class TransactionService {
	private List<Transaction> transactionsInMemory = new ArrayList<>();
	
	//Adding transactions (Creating)
	public String addTransaction(Transaction transaction)
	{
		 for (Transaction t : transactionsInMemory) {
		        if (t.getTransactionId() == transaction.getTransactionId()) {
		            return "Transaction ID already exists";
		        }
		    }
		 
		 if (!transaction.getTransactionType().equalsIgnoreCase("INCOME")
			        && !transaction.getTransactionType().equalsIgnoreCase("EXPENSE")) {
			    return "Invalid transaction type";
			}
		 
		 if (transaction.getTransactionType().equalsIgnoreCase("EXPENSE")) {

			    double totalIncome = 0;
			    double totalExpense = 0;

			    for (Transaction t : transactionsInMemory) {
			        if (t.getTransactionType().equalsIgnoreCase("INCOME")) {
			            totalIncome += t.getTransactionAmount();
			        } else if (t.getTransactionType().equalsIgnoreCase("EXPENSE")) {
			            totalExpense += t.getTransactionAmount();
			        }
			    }

			    double currentBalance = totalIncome - totalExpense;

			    if (transaction.getTransactionAmount() > currentBalance) {
			        return "Insufficient balance";
			    }
			}
		 
		transactionsInMemory.add(transaction);
		return "Transaction added successfully";
	}
	
	
	//Retrieving transactions (Reading)
	public List<Transaction> getAllTransactions()
	{
		return transactionsInMemory;
	}
	
	//Updating transaction (Updating)
	public String updateTransaction(int transactionId, Transaction updatedTransaction) {

	    for (Transaction t : transactionsInMemory) {

	        if (t.getTransactionId() == transactionId) {

	            if (!updatedTransaction.getTransactionType().equalsIgnoreCase("INCOME")
	                    && !updatedTransaction.getTransactionType().equalsIgnoreCase("EXPENSE")) {
	                return "Invalid transaction type";
	            }

	            if (updatedTransaction.getTransactionType().equalsIgnoreCase("EXPENSE")) {

	                double totalIncome = 0;
	                double totalExpense = 0;

	                for (Transaction existingTransaction : transactionsInMemory) {

	                    if (existingTransaction.getTransactionId() == transactionId) {
	                        continue;
	                    }

	                    if (existingTransaction.getTransactionType().equalsIgnoreCase("INCOME")) {
	                        totalIncome += existingTransaction.getTransactionAmount();
	                    } 
	                    else if (existingTransaction.getTransactionType().equalsIgnoreCase("EXPENSE")) {
	                        totalExpense += existingTransaction.getTransactionAmount();
	                    }
	                }

	                double currentBalance = totalIncome - totalExpense;

	                if (updatedTransaction.getTransactionAmount() > currentBalance) {
	                    return "Insufficient balance";
	                }
	            }

	            t.setTransactionAmount(updatedTransaction.getTransactionAmount());
	            t.setTransactionType(updatedTransaction.getTransactionType());
	            t.setTransactionCategory(updatedTransaction.getTransactionCategory());
	            t.setTransactionDate(updatedTransaction.getTransactionDate());

	            return "Transaction updated successfully";
	        }
	    }

	    return "Transaction not found";
	} 	
	
	//Deleting transaction (Deleting)
	public String deleteTransaction(int transactionId) {

	    for (int i = 0; i < transactionsInMemory.size(); i++) {

	        if (transactionsInMemory.get(i).getTransactionId() == transactionId) {
	            transactionsInMemory.remove(i);
	            return "Transaction deleted successfully";
	        }
	    }

	    return "Transaction not found";
	}
	
	public List<Transaction> filterByTransactionType(String transactionType)
	{
		List<Transaction> filteredResult=new ArrayList<>();
		for(Transaction t:transactionsInMemory)
		{
			if(t.getTransactionType().equalsIgnoreCase(transactionType))
			{
				filteredResult.add(t);
			}
		}
		return filteredResult;
	}
}