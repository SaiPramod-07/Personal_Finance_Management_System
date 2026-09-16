package com.sai.pramod.MODEL;

import java.util.Map;

// Represents the summary of financial transactions.
public class TransactionSummary {
	private double totalIncome; //How much money did I receive?
	private double totalExpense; //How much money did I spend?
	private double remainingBalance; //How much money do I currently have left?
	private Map<String, Double> categoryWiseExpenses;
	
	public TransactionSummary(double totalIncome,double totalExpense, double remainingBalance, Map<String,Double>categoryWiseExpenses)
	{
		this.totalIncome=totalIncome;
		this.totalExpense=totalExpense;
		this.remainingBalance = remainingBalance;
		this.categoryWiseExpenses=categoryWiseExpenses;
	}
	
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}
	
	public double getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(int totalExpense) {
		this.totalExpense = totalExpense;
	}
	
	public double getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(int remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	public Map<String, Double> getCategoryWiseExpense() {
		return categoryWiseExpenses;
	}
}
