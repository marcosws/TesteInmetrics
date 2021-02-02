package br.com.inmetrics.teste.pages;

import br.com.inmetrics.teste.support.BasePage;

public class LoginWebPage extends BasePage {
	
	
	public String recuperarTitulo() {
		String valor = "/html/body/div/div[2]/div/form/span";
		if(this.aguardar(Atributo.XPATH, valor, 10)) 
			return this.recuperarTexto(Atributo.XPATH, valor);
		return "";
	}
	
	public void digitarUsuario(String usuario) {
		this.editar(Atributo.NAME, "username", usuario);
	}
	
	public void digitarSenha(String senha) {
		this.editar(Atributo.NAME, "pass", senha);
	}
	
	public void clicarEntre() { 
		this.clicar(Atributo.XPATH, "/html/body/div/div[2]/div/form/div[6]/button");
	}
	
	public void clicarCadastreSe() {
		this.clicar(Atributo.XPATH, "/html/body/nav/div/div/ul/li[1]/a");
	}
	
	public String recuperarLinkFuncionarios() {  
		String valor = "/html/body/nav/div/div/ul/li[1]/a"; 
		Atributo atributo = Atributo.XPATH;
		if(this.aguardar(atributo, valor, 10)) 
			return this.recuperarTexto(atributo, valor).trim();    
		return "";
	}
	
	public String recuperarMensagemUsuarioOuSenhaInvalidos() { 
		String valor = "/html/body/div/div[1]/div"; 
		Atributo atributo = Atributo.XPATH;
		if(this.aguardar(atributo, valor, 10)) {
			String texto = this.recuperarTexto(atributo, valor);
			return texto.replace("\r", "").replace("\n", "").replace("×", "");
		}
		return "";
	}

}
