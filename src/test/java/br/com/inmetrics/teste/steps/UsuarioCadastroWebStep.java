package br.com.inmetrics.teste.steps;

import org.junit.Assert;

import br.com.inmetrics.teste.pages.UsuarioCadastroWebPage;
import br.com.inmetrics.teste.support.Utils;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class UsuarioCadastroWebStep {
	
	@Então("valido o acesso a tela Cadastre-se")
	public void valido_o_acesso_a_tela_cadastre_se() {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		Assert.assertEquals("Validação da tela Cadastre-se","Cadastre-se", usuarioCadastroWebPage.recuperaTitulo());  
	}

	@Quando("informar um novo usuario {string}")
	public void informar_um_novo_usuario(String usuario) {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		// REMOVER - gera um codigo aleatorio para evitar cadastro duplicado
		// apenas para não quebrar o cenário em uma segunda execução
		usuario = usuario.replaceAll("<n>", Utils.randomNumber(1000)); 
		// =============================================================
		usuarioCadastroWebPage.digitarUsuario(usuario);
	}

	@Quando("informar uma nova senha {string}")
	public void informar_uma_nova_senha(String senha) {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		usuarioCadastroWebPage.digitarSenha(senha);
	}

	@Quando("confirmar a nova senha {string}")
	public void confirmar_a_nova_senha(String confirmeSenha) {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		usuarioCadastroWebPage.digitarConfirmeSenha(confirmeSenha);
	}

	@Quando("clicar no botão Cadastrar")
	public void clicar_no_botão_cadastrar() {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		usuarioCadastroWebPage.clicarCadastrar();
	}

	@Então("valido a mensagem apresentada {string}")
	public void valido_a_mensagem_apresentada(String mensagem) {
		UsuarioCadastroWebPage usuarioCadastroWebPage = new UsuarioCadastroWebPage();
		if(mensagem.equals("Usuário já cadastrado"))
			Assert.assertTrue(usuarioCadastroWebPage.validarMensagemUsuarioJaCadastrado());
		else if(mensagem.equals("Senhas não combinam"))
			Assert.assertTrue(usuarioCadastroWebPage.validarMensagemSenhasNaoCombinam());
	}
			
}
