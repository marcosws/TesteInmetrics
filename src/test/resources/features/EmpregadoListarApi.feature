#language: pt

@global @api @empregado @empregadoListar
Funcionalidade: realizar a chamada api listando o empregado pelo id

	@positivo
	Cenário: listar o empregado informando o id válido
		Dado que tenho acesso a api listar empregado
		Quando realizar a requisição do empregado informando o id "555"
		Então a api retorna o empregado conforme id do parametro
		
	@negativo
	Cenário: listar o empregado informando o id inválido
		Dado que tenho acesso a api listar empregado
		Quando realizar a requisição do empregado informando o id ""
		Então a api retorna o codigo de não encontrado