#language: pt

@global @app @login
Funcionalidade: realizar login na aplicação

	Contexto: acessar a aplicação realizando o login
		Dado que usuário possa acessar a tela de login da aplicação

	@positivo
	Esquema do Cenário: realizar login na aplicação informando usuário e senha válidos
		Quando informar o usuário <usuario>
		E inserir uma senha <senha>
		E clicar no botão entre
		Então validar o acesso a aplicação
		
	Exemplos:
	| usuario  | senha    |
	| "marcos" | "socram" |
		
		
	@negativo
	Esquema do Cenário: realizar login na aplicação informando usuário e senha inválidos
		Quando informar o usuário <usuario>
		E inserir uma senha <senha>
		E clicar no botão entre
		Então validar a mensagem "ERRO! Usuário ou Senha inválidos"

		
	Exemplos:
	| usuario  | senha    |
	| "marcos" | "xxxmm"  |




