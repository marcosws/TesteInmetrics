package br.com.inmetrics.teste.steps;

import org.junit.Assert;

import br.com.inmetrics.teste.pages.FuncionariosWebPage;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FuncionariosWebStep {
	
	@Quando("clicar em Novo Funcionario")
	public void clicar_em_novo_funcionario() {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.clicarNovoFuncionario();
	}

	@Quando("digitar o nome {string}")
	public void digitar_o_nome(String nome) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.digitarNome(nome);
	}

	@Quando("digitar o cpf {string}")
	public void digitar_o_cpf(String cpf) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.digitarCpf(cpf);
	}

	@Quando("selecionar o sexo {string}")
	public void selecionar_o_sexo(String sexo) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.selecionarSexo(sexo);
	}

	@Quando("digitar o admissão {string}")
	public void digitar_o_admissão(String admissao) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.digitarAdmissao(admissao);
	}

	@Quando("digitar o cargo {string}")
	public void digitar_o_cargo(String cargo) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.digitarCargo(cargo);
	}

	@Quando("digitar o salario {string}")
	public void digitar_o_salario(String salario) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.digitarSalario(salario);
	}

	@Quando("selecionar o tipo de contratação {string}")
	public void selecionar_o_tipo_de_contratação(String tipoContratacao) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.selecionarTipoContratacao(tipoContratacao);
	}

	@Quando("clicar em enviar")
	public void clicar_em_enviar() {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		funcionariosWebPage.clicarEnviar();
	}

	@Então("valido a mensagem {string}")
	public void valido_a_mensagem(String mensagem) {
		FuncionariosWebPage funcionariosWebPage = new FuncionariosWebPage();
		Assert.assertEquals("Validação da Mensagem", mensagem, funcionariosWebPage.recuperarMensagemSucesso());
		
	}

}
