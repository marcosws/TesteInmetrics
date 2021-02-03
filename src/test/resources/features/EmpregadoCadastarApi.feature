#language: pt

@global @api @empregado @empregadoCadastrar
Funcionalidade: realizar a chamada api cadastrando o empregado

	@positivo
	Cenário: cadastrar o empregado informando os dados
		Dado que tenho acesso a api cadastrar empregado
		Quando enviar os dados do cadastro na requisição
		Então a api retorna os dados cadastrados
