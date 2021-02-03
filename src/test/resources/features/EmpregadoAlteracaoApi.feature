#language: pt

@global @api @empregado @empregadoAlterar
Funcionalidade: realizar a chamada api alterando o empregado

	@positivo
	Cenário: alterar o empregado informando os dados
		Dado que tenho acesso a api alterar empregado
		Quando enviar os dados da alteração na requisição passando o id "602"
		Então a api retorna os dados alterados