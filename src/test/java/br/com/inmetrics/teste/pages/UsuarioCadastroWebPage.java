package br.com.inmetrics.teste.pages;

import br.com.inmetrics.teste.support.BasePage;

public class UsuarioCadastroWebPage extends BasePage {
	
	
	public String recuperaTitulo() {
		String valor = "/html/body/div/div/div/form/span";
		Atributo atributo = Atributo.XPATH;
		if(this.aguardar(atributo, valor, 10))
			return this.recuperarTexto(atributo, valor);
		return "";
	}
	
	public void digitarUsuario(String usuario) { 
		this.editar(Atributo.NAME, "username", usuario);
	}
	
	public void digitarSenha(String senha) {  
		this.editar(Atributo.NAME, "pass", senha);
	}
	
	public void digitarConfirmeSenha(String confirmeSenha) { 
		this.editar(Atributo.NAME, "confirmpass", confirmeSenha);
	}
	
	public void clicarCadastrar() { //
		this.clicar(Atributo.XPATH, "/html/body/div/div/div/form/div[7]/button");
	}
	
	public boolean validarMensagemUsuarioJaCadastrado() {
		return this.recuperarTexto(Atributo.XPATH, "/html/body/div/div/div/form/div[1]/span/div").trim().equals("Usuário já cadastrado");
		
	}
	
	public boolean validarMensagemSenhasNaoCombinam() {
		return this.recuperarTexto(Atributo.XPATH, "/html/body/div/div/div/form/div[3]/span/div").trim().equals("Senhas não combinam");
	}

}
