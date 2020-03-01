package com.expenses.transactions.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_transaction")
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtTransaction;
	
//	@ManyToOne
//	@JoinColumn(name="accountSource")
//	private Account accountSource;

//	@ManyToOne
//	@JoinColumn(name="accountDestination")
//	private Account accountDestination;
	
//	private Category transactionCategory;

	private LocalDate transactionDate;
	
	private BigDecimal value;
	
	private String description;

	public Long getIdtTransaction() {
		return idtTransaction;
	}

	public Transaction setIdtTransaction(Long idtTransaction) {
		this.idtTransaction = idtTransaction;
		return this;
	}

//	public Category getTransactionCategory() {
//		return transactionCategory;
//	}
//	
//	public Account getAccountSource() {
//		return accountSource;
//	}
//
//	public void setAccountSource(Account accountSource) {
//		this.accountSource = accountSource;
//	}
//
//	public Account getAccountDestination() {
//		return accountDestination;
//	}
//
//	public void setAccountDestination(Account accountDestination) {
//		this.accountDestination = accountDestination;
//	}
//
//	public void setTransactionCategory(Category transactionCategory) {
//		this.transactionCategory = transactionCategory;
//	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public Transaction setTransactionDate(LocalDate date) {
		this.transactionDate = date;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Transaction setValue(BigDecimal value) {
		this.value = value;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Transaction setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtTransaction == null) ? 0 : idtTransaction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (idtTransaction == null) {
			if (other.idtTransaction != null)
				return false;
		} else if (!idtTransaction.equals(other.idtTransaction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + transactionDate + ", value=" + value + ", description=" + description
				+ "]";
	}
}

