package com.expenses.transactions.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.transactions.entity.Transaction;
import com.expenses.transactions.entity.TransactionRepository;

@Service
public class TransactionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		LOGGER.info(String.format("Transaction saved successfully: %s", transaction.toString()));
	}
	
//	public void saveTransaction(AccountTransaction accountTransaction) {
//		accountTransactionRepository.save(accountTransaction);
//	}
//	
//	public List<TransactionResponse> getAllTransactions() {
//		return toTransactionResponse(accountTransactionRepository.findAll());
//	}
//
//	public List<TransactionResponse> toTransactionResponse(List<AccountTransaction> transactions) {
//		List<TransactionResponse> transactionResponses = new ArrayList<TransactionResponse>();
//		
//		for(AccountTransaction t : transactions) {
//			TransactionResponse response = new TransactionResponse();
//			
//			response.setIdtTransaction(t.getIdtTransaction());
//			response.setDescription(t.getDescription());
////			response.setTransactionCategory(t.getTransactionCategory());
////			response.setTransactionDate(ZonedDateTime.ofInstant(t.getTransactionDate().toInstant(), ZoneId.systemDefault()));
////			response.setValue(t.getValue());
//			
//			if(!(t.getAccountSource() == null)) {
//				response.setAccountSource(toAccountResponse(t.getAccountSource()));
//			}
//			
//			if(!(t.getAccountDestination() == null)) {
//				response.setAccountDestination(toAccountResponse(t.getAccountDestination()));
//			}
//			
//			transactionResponses.add(response);
//		}
//		
//		return transactionResponses;
//	}
//	
//	public AccountResponse toAccountResponse(Account account) {
//		AccountResponse response = new AccountResponse();
//		response.setAccountName(account.getAccountName());
//		response.setAccountNick(account.getAccountNick());
//		response.setAccountNumber(account.getAccountNumber());
//		response.setAccountType(account.getAccountType());
//		response.setBalance(account.getBalance());
//		response.setBankNumber(account.getBanckNumber());
//		response.setInitialBalance(account.getInitialBalance());
//		
//		return response;
//	}
}

