package br.com.inmetrics.teste.pages;

import br.com.inmetrics.teste.support.BasePage;

public class FuncionariosWebPage extends BasePage {
	
	
	public void digitarPesquisar(String pesquisar) {// 
		this.editar(Atributo.XPATH, "/html/body/div/div[2]/div/div[2]/label/input", pesquisar);
	}
	public void clicarNovoFuncionario() { 
		this.clicar(Atributo.XPATH, "/html/body/nav/div/div/ul/li[2]/a");
	}
	public void digitarNome(String nome) { 
		this.editar(Atributo.ID, "inputNome", nome);
	}
	public void digitarCpf(String cpf) { 
		if(!cpf.equals(""))
			this.editar(Atributo.ID, "cpf", cpf);
	}
	public void selecionarSexo(String sexo)	{
		this.selecionar(Atributo.ID, "slctSexo", sexo);
	}
	public void digitarAdmissao(String admissao) {
		this.editar(Atributo.ID, "inputAdmissao", admissao);
	}
	public void digitarCargo(String cargo) { 
		this.editar(Atributo.ID, "inputCargo", cargo);
	}
	public void digitarSalario(String salario) { 
		this.editar(Atributo.ID, "dinheiro", salario);
	}
	public void selecionarTipoContratacao(String tipoContratacao) { 
		if(tipoContratacao.equalsIgnoreCase("CLT")) {
			this.selecionar(Atributo.ID, "clt", true);
		}
		else if(tipoContratacao.equalsIgnoreCase("PJ")) {
			this.selecionar(Atributo.ID, "pj", true);
		}
	}
	public void clicarEnviar() {
		if(this.aguardar(Atributo.XPATH, "/html/body/div/div/div/form/div[3]/input", 3))
			this.clicar(Atributo.XPATH, "/html/body/div/div/div/form/div[3]/input");
		if(this.aguardar(Atributo.XPATH, "/html/body/div/div[2]/div/form/div[3]/input", 3))
			this.clicar(Atributo.XPATH, "/html/body/div/div[2]/div/form/div[3]/input");
	}
	
	public void clicarAlterar() {    
		this.clicar(Atributo.XPATH, "/html/body/div/div[2]/div/table/tbody/tr[1]/td[6]/a[2]/button");
	}
	
	public void clicarExcluir() {
		this.clicar(Atributo.XPATH, "/html/body/div/div[2]/div/table/tbody/tr[1]/td[6]/a[1]/button");
	}
	
	
	public String recuperarMensagemSucesso() {
		return this.recuperarTexto(Atributo.XPATH, "/html/body/div/div[1]/div").replace("\r", "").replace("\n", "").replace("×", "");
	}

	

}
