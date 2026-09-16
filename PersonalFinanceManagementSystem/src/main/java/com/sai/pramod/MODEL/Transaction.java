package com.sai.pramod.MODEL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

//Represents an individual financial transaction.
public class Transaction {
	
	private int transactionId;
	
	@Positive
	private double transactionAmount;
	
	@NotBlank
	private String transactionType;
	
	@NotBlank
	private String transactionCategory;
	
	@NotBlank
	private String transactionDate;
	
	
	public int getTransactionId()
	{
		return transactionId;
	}
	public void setTransactionId(int newTransactionId)
	{
		this.transactionId=newTransactionId;
	}
	
	
	public double getTransactionAmount() 
	{
		return transactionAmount;
	}
	public void setTransactionAmount(double newTransactionAmount) 
	{
		this.transactionAmount = newTransactionAmount;
	}
	
	
	public String getTransactionType() 
	{
		return transactionType;
	}
	public void setTransactionType(String newTransactionType) 
	{
		this.transactionType = newTransactionType;
	}
	
	
	public String getTransactionCategory() 
	{
		return transactionCategory;
	}
	public void setTransactionCategory(String newTransactionCategory) {
		this.transactionCategory = newTransactionCategory;
	}
	
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String newTransactionDate) {
		this.transactionDate = newTransactionDate;
	}
	
	
}
