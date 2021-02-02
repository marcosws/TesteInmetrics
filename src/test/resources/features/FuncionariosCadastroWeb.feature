#language: pt

@global @app @funcionarios @funcinariosCadastro
Funcionalidade: realizar o cadastro de funcionario na aplicação

	Contexto: realizar o cadastro de funcionario
		Dado que usuário possa acessar a tela de login da aplicação
	  Quando informar o usuário "marcos"
		E inserir uma senha "socram"
		E clicar no botão entre
		E clicar em Novo Funcionario

	@positivo
	Esquema do Cenário: realizar o cadastro de funcionarios com dados válidos
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
		| nome             | cpf               | sexo         | admissao      | cargo                     | salario     | tipoContratacao  | mensagem                                   |
		| "Ronald Reagan"  | "339.316.173-35"  | "Masculino"  | "10/10/2020"  | "Presidente do Conselho"  | "22000077"  | "PJ"             | "SUCESSO! Usuário cadastrado com sucesso"  |
		

	