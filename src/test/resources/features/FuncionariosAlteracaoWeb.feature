#language: pt

@global @app @funcionarios @funcinariosAlteracao
Funcionalidade: realizar a alteração de funcionario na aplicação

	Contexto: realizar a alteração de funcionario
		Dado que usuário possa acessar a tela de login da aplicação
	  Quando informar o usuário "marcos"
		E inserir uma senha "socram"
		E clicar no botão entre
		
	@positivo
	Esquema do Cenário: realizar a alteração de funcionario com dados válidos
		E digitar em pesquisar o nome <nomePesquisar>
		E clicar em alterar
		E digitar o nome <nome>
		E digitar o cpf <cpf>
		E selecionar o sexo <sexo>
		E digitar o admissão <admissao>
		E digitar o cargo <cargo>
		E digitar o salario <salario>
		E selecionar o tipo de contratação <tipoContratacao>
		E clicar em enviar
		Então valido a mensagem <mensagem>
		
			Exemplos:	
		| nomePesquisar   | nome             | cpf               | sexo         | admissao      | cargo                     | salario     | tipoContratacao  | mensagem                                        |
		| "Ronald Reagan" | "Ronald Reagan"  | ""                | "Masculino"  | "08/09/2020"  | "Presidente do Conselho"  | "1800077"   | "CLT"            | "SUCESSO! Informações atualizadas com sucesso"  |
