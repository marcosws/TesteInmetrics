package br.com.inmetrics.teste.steps;


import org.junit.Assert;

import br.com.inmetrics.teste.pages.LoginWebPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginWebStep {
	
	@Dado("que usuário possa acessar a tela de login da aplicação")
	public void que_usuário_possa_acessar_a_tela_de_login_da_aplicação() {
		LoginWebPage loginWebPage = new LoginWebPage();
		Assert.assertEquals("Tela de Login", "Login", loginWebPage.recuperarTitulo());
	}

	@Quando("informar o usuário {string}")
	public void informar_o_usuário(String usuario) {
		LoginWebPage loginWebPage = new LoginWebPage();
		loginWebPage.digitarUsuario(usuario);
	}

	@Quando("inserir uma senha {string}")
	public void inserir_uma_senha(String senha) {
		LoginWebPage loginWebPage = new LoginWebPage();
		loginWebPage.digitarSenha(senha);
	}

	@Quando("clicar no botão entre")
	public void clicar_bo_botão_entre() {
		LoginWebPage loginWebPage = new LoginWebPage();
		loginWebPage.clicarEntre();
	}

	@Então("validar o acesso a aplicação")
	public void validar_o_acesso_a_aplicação() {
		LoginWebPage loginWebPage = new LoginWebPage();
		Assert.assertEquals("Tela de Login", "FUNCIONÁRIOS", loginWebPage.recuperarLinkFuncionarios());
	}

	@Então("validar a mensagem {string}")
	public void validar_a_mensagem(String  mensagem) {
		LoginWebPage loginWebPage = new LoginWebPage();
		Assert.assertEquals("Tela de Login", mensagem, loginWebPage.recuperarMensagemUsuarioOuSenhaInvalidos());
	}
	
	@Quando("clicar no link Cadastre-se")
	public void clicar_no_link_cadastre_se() {
		LoginWebPage loginWebPage = new LoginWebPage();
		loginWebPage.clicarCadastreSe();
	}
	
	@Então("valido o retorno a tela de Login")
	public void valido_o_retorno_a_tela_de_login() {
		LoginWebPage loginWebPage = new LoginWebPage();
		Assert.assertEquals("Tela de Login", "Login", loginWebPage.recuperarTitulo());
	}


}
