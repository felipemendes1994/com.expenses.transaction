package com.expenses.transactions.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.transactions.rest.dao.TransactionRequest;
import com.expenses.transactions.service.TransactionService;

@RestController
public class TransactionsRest {
	
	@Autowired
	private TransactionService service;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/transactions")
	public void createTransaction(@RequestBody TransactionRequest request) {
		service.saveTransaction(request.toTransaction());
	}

}
