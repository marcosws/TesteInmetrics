package br.com.inmetrics.teste.api;

import br.com.inmetrics.teste.support.Context;
import br.com.inmetrics.teste.support.Utils;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmpregadoApi {
	
	private static RequestSpecification request;
	private static Response response;
	
	public enum Method{
		POST, PUT;
	}
	
	public static RequestSpecification getRequest() {
		return request;
	}
	
	public static Response getResponse() {
		return response;
	}
	
	public static void setResponse(String partUrl) {
		response = request.get(partUrl);
	}
	
	public static void setResponse(String partUrl, String bodyJsonFile, Method method) {
		System.out.println(Utils.retornaJson(bodyJsonFile));
		if(method.equals(Method.POST)) {
			response = request.contentType("application/json").body(Utils.retornaJson(bodyJsonFile)).post(partUrl);
		}
		else if(method.equals(Method.PUT)) {
			response = request.contentType("application/json").body(Utils.retornaJson(bodyJsonFile)).put(partUrl);
		}
	}
	
	public static void setRequest() {
		RestAssured.baseURI = Context.INMETRICS_API;
		request = RestAssured.given();
		request.header("Authorization", "Basic aW5tZXRyaWNzOmF1dG9tYWNhbw==");
		request.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	}
	
	public static boolean validarSchemaJson(String jsonFile) {
		try {
			JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(Utils.retornaJson(jsonFile));
			response.then().assertThat().body(validator);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void mostraEmpregado() {
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("	empregadoId:     " + jsonPathEvaluator.get("empregadoId"));
		System.out.println("	nome:            " + jsonPathEvaluator.get("nome"));
		System.out.println("	sexo:            " + jsonPathEvaluator.get("sexo"));
		System.out.println("	cpf:             " + jsonPathEvaluator.get("cpf"));
		System.out.println("	cargo:           " + jsonPathEvaluator.get("cargo"));
		System.out.println("	admissao:        " + jsonPathEvaluator.get("admissao"));
		System.out.println("	salario:         " + jsonPathEvaluator.get("salario"));
		System.out.println("	comissao:        " + jsonPathEvaluator.get("comissao"));
		System.out.println("	tipoContratacao: " + jsonPathEvaluator.get("tipoContratacao"));
	}
	

}
