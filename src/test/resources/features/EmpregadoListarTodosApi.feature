#language: pt

@global @api @empregado @empregadoListarTodos
Funcionalidade: realizar a chamada api listando o todos os empregados

	@positivo
	Cenário: listar todos so empregados
		Dado que tenho acesso a api listar empregado
		Quando realizar a requisição do empregado listando todos
		Então a api retorna a lista de todos os empregados
