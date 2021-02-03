#language: pt

@global @app @funcionarios @funcinariosExclusao
Funcionalidade: realizar a exclusão de funcionario na aplicação

	Contexto: realizar a exclusão de funcionario
		Dado que usuário possa acessar a tela de login da aplicação
	  Quando informar o usuário "marcos"
		E inserir uma senha "socram"
		E clicar no botão entre
		
	@positivo
	Esquema do Cenário: realizar a exclusão de funcionario com dados válidos
		E digitar em pesquisar o nome <nomePesquisar>
		E clicar em excluir
		Então valido a mensagem <mensagem>
		
	Exemplos:	
		| nomePesquisar   | mensagem                                     |
		| "Ronald Reagan" | "SUCESSO! Funcionário removido com sucesso"  |
		