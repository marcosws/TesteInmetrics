package br.com.inmetrics.teste.steps;

import org.junit.Assert;

import br.com.inmetrics.teste.api.EmpregadoApi;
import br.com.inmetrics.teste.api.EmpregadoApi.Method;
import br.com.inmetrics.teste.support.Context;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class EmpregadoApiStep {
	

	@Dado("que tenho acesso a api listar empregado")
	public void que_tenho_acesso_a_api_listar_empregado() {
		EmpregadoApi.setRequest();
	}

	@Quando("realizar a requisição do empregado informando o id {string}")
	public void realizar_a_requisicao_do_empregado_informando_o_id(String id) {
		EmpregadoApi.setResponse(Context.LISTAR_EMPREGADO.replace("{id}", id));
	}

	@Então("a api retorna o empregado conforme id do parametro")
	public void a_api_retorna_o_empregado_conforme_id_do_parametro() {
		Assert.assertEquals(202, EmpregadoApi.getResponse().getStatusCode());
		String jsonRetorno = EmpregadoApi.getResponse().asString();
		Assert.assertTrue(jsonRetorno.contains("\"empregadoId\":555"));
		EmpregadoApi.mostraEmpregado();
	}
	
	@Então("a api retorna o codigo de não encontrado")
	public void a_api_retorna_o_codigo_de_não_encontrado() {
		Assert.assertEquals(404, EmpregadoApi.getResponse().getStatusCode());
	}
	
	@Quando("realizar a requisição do empregado listando todos")
	public void realizar_a_requisição_do_empregado_listando_todos() {
		EmpregadoApi.setResponse(Context.LISTAR_TODOS_EMPREGADOS);
	}

	@Então("a api retorna a lista de todos os empregados")
	public void a_api_retorna_a_lista_de_todos_os_empregados() {
		Assert.assertEquals(200, EmpregadoApi.getResponse().getStatusCode());
		Assert.assertTrue(EmpregadoApi.validarSchemaJson("empregado_listar_todos_schema.json"));
	}
	
	@Dado("que tenho acesso a api cadastrar empregado")
	public void que_tenho_acesso_a_api_cadastrar_empregado() {
		EmpregadoApi.setRequest();
	}

	@Quando("enviar os dados do cadastro na requisição")
	public void enviar_os_dados_do_cadastro_na_requisição() {
		EmpregadoApi.setResponse(Context.CADASTRAR_EMPREGADO,"empregado_cadastro_body.json", Method.POST);
	}

	@Então("a api retorna os dados cadastrados")
	public void a_api_retorna_os_dados_cadastrados() {
		Assert.assertEquals(202, EmpregadoApi.getResponse().getStatusCode());
		EmpregadoApi.mostraEmpregado();
	}
	
	@Dado("que tenho acesso a api alterar empregado")
	public void que_tenho_acesso_a_api_alterar_empregado() {
		EmpregadoApi.setRequest();
	}

	@Quando("enviar os dados da alteração na requisição passando o id {string}")
	public void enviar_os_dados_da_alteração_na_requisição_passando_o_id(String id) {
		EmpregadoApi.setResponse(Context.ALTERAR_EMPREGADO.replace("{id}", id),"empregado_alteracao_body.json", Method.PUT);
	}

	@Então("a api retorna os dados alterados")
	public void a_api_retorna_os_dados_alterados() {
		Assert.assertEquals(202, EmpregadoApi.getResponse().getStatusCode());
		EmpregadoApi.mostraEmpregado();
	}

}
