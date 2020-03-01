package com.expenses.transactions.rest.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.expenses.transactions.entity.Transaction;

public class TransactionRequest {

	private String datTransaction;

	private BigDecimal value;

	private String description;

	public String getDatTransaction() {
		return datTransaction;
	}

	public void setDatTransaction(String datTransaction) {
		this.datTransaction = datTransaction;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
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
				.setValue(value)
				.setTransactionDate(LocalDate.parse(datTransaction, DateTimeFormatter.ofPattern("yyyyMMdd")));
	}
}
