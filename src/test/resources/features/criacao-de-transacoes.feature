#language: pt

Funcionalidade: Fluxo de Criacao de Transacoes

	Cenario: Criacao de transacao com sucesso sem transacoes existentes no banco
		Dado que nao existam transacoes no banco
		Quando a API de POST "/transactions" for chamada com o payload
		"""
			{
				"datTransaction":"20190604",
				"value":"-1720.00",
				"description":"TRANSFERENCIA A DEBITO 00019 0017035406 FELIPE DE SOUZA MENDES"
			}
		"""
		Entao a API respondera com o status 201
		E havera os seguintes registros no banco
		| datTransaction | value    | description 																									 |
		| 2019-06-04  	 | -1720.00 | TRANSFERENCIA A DEBITO 00019 0017035406 FELIPE DE SOUZA MENDES |
	
	Cenario: Criacao de transacao com sucesso com transacoes existentes no banco
		Dado que as seguintes transacoes existam no banco
		| datTransaction | value    | description 																									 |
		| 2019-06-04		 | -1720.00 | TRANSFERENCIA A DEBITO 00019 0017035406 FELIPE DE SOUZA MENDES |
		Quando a API de POST "/transactions" for chamada com o payload
		"""
			{
				"datTransaction":"20190613",
				"value":"-188.90",
				"description":"PAGAMENTO DE TITULO CONTADOR 06/19"
			}
		"""
		Entao a API respondera com o status 201
		E havera os seguintes registros no banco
		| datTransaction | value    | description 																									 |
		| 2019-06-04		 | -1720.00 | TRANSFERENCIA A DEBITO 00019 0017035406 FELIPE DE SOUZA MENDES |
		| 2019-06-13		 | -188.90  | PAGAMENTO DE TITULO CONTADOR 06/19														 |
		
		
		