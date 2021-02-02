#language: pt

@global @app @cadastro
Funcionalidade: realizar cadastro de usuario

	Contexto: realizar o cadastro de usuário
		Dado que usuário possa acessar a tela de login da aplicação
		Quando clicar no link Cadastre-se
		Então valido o acesso a tela Cadastre-se

	@positivo
	Esquema do Cenário: realizar o cadastro de usuário na aplicação informando dados válidos
		Quando informar um novo usuario <usuario>
		E informar uma nova senha <senha>
		E confirmar a nova senha <confirmeSenha>
		E clicar no botão Cadastrar
		Então valido o retorno a tela de Login
		
	Exemplos:
		| usuario       | senha         | confirmeSenha    |
		| "igorromanov" | "igorromanov" | "igorromanov"    |
		
	@negativo
	Esquema do Cenário: realizar o cadastro de usuário na aplicação informando dados inválidos
		Quando informar um novo usuario <usuario>
		E informar uma nova senha <senha>
		E confirmar a nova senha <confirmeSenha>
		E clicar no botão Cadastrar
		Então valido a mensagem apresentada <mensagem>
		
	Exemplos:
		| usuario         | senha          | confirmeSenha   | mensagem                 |
		| "nigelmansell"  | "nigelmansell" | "nigelmansell"  | "Usuário já cadastrado"  |
		| "nikilauda"     | "nikilauda"    | "laudaniki"     | "Senhas não combinam"    |
		
		




