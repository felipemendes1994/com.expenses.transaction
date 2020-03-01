package com.expenses.transactions.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.expenses.transactions.entity.Transaction;
import com.expenses.transactions.entity.TransactionRepository;
import com.expenses.transactions.utility.HttpCommonResponse;
import com.expenses.transactions.utility.TransactionData;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CriacaoDeTransacao {
	
	@Autowired
	TransactionRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders defaultHeaders;
	
	@Autowired
	HttpCommonResponse result;

	@Dado("^que nao existam transacoes no banco$")
	public void que_nao_existam_transacoes_no_banco() throws Throwable {
		assertEquals(0, repository.findAll().size());
	}

	@Quando("^a API de POST \"([^\"]*)\" for chamada com o payload$")
	public void a_API_de_POST_for_chamada_com_o_payload(String url, String payload) throws Throwable {
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(payload, defaultHeaders), String.class);
		result.setBody(response.getBody());
		result.setStatus(response.getStatusCode());
	}

	@Entao("^a API respondera com o status (\\d+)$")
	public void a_API_respondera_com_o_status(int status) throws Throwable {
		assertEquals(status, result.getStatus().value());
	}

	@Entao("^havera os seguintes registros no banco$")
	public void havera_os_seguintes_registros_no_banco(List<TransactionData> transactionDataList) throws Throwable {
		List<Transaction> transacations = repository.findAll();
		
		assertEquals(transactionDataList.size(), transacations.size());
		int i = 0;
		for(TransactionData t : transactionDataList) {
			assertEquals(t.getDatTransaction(), transacations.get(i).getTransactionDate());
			assertEquals(t.getValue(), transacations.get(i).getValue());
			assertEquals(t.getDescription(), transacations.get(i).getDescription());
			
			i++;
		}
	}

	@Dado("^que as seguintes transacoes existam no banco$")
	public void que_as_seguintes_transacoes_existam_no_banco(List<TransactionData> transactionDataList) throws Throwable {
		for(TransactionData t : transactionDataList) {
			repository.save(t.toTransaction());
		}
		
		assertEquals(transactionDataList.size(), repository.findAll().size());
	}
}
