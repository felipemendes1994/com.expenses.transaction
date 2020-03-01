package com.expenses.transactions.utility;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.expenses.transactions.entity.Transaction;

public class TransactionData {
	
	private String datTransaction;
	private String value;
	private String description;
	
	public LocalDate getDatTransaction() {
		return LocalDate.parse(datTransaction);
	}
	public void setDatTransaction(String datTransaction) {
		this.datTransaction = datTransaction;
	}
	public BigDecimal getValue() {
		return new BigDecimal(value);
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Transaction toTransaction() {
		return new Transaction()
				.setDescription(description)
				.setValue(new BigDecimal(value))
				.setTransactionDate(LocalDate.parse(datTransaction, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
}
