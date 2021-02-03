package br.com.inmetrics.teste.support;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static Scenario scenario;
	private static Collection<String> tags;
	public static Scenario getScenario() {
		return scenario;
	}

	@Before
	public void beforeScenario(Scenario scenario){
		
		Hooks.scenario = scenario;
		tags = Hooks.getScenario().getSourceTagNames();
		if(tags.contains("@api")) {
			System.out.println("Iniciando os testes da API");
			System.out.println("Executando: " + Hooks.getScenario().getName());
		}
		else {
			System.out.println("Iniciando os testes");
			System.out.println("Executando: " + Hooks.getScenario().getName());
			DriverFactory.setDriver(Browser.CHROME);// <= Opções de browser IE, EDGE, CHROME, FIREFOX, OPERA;
			DriverFactory.getDriver().manage().window().maximize();
			DriverFactory.getDriver().get(Context.INMETRICS_APP);
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			String nome = Hooks.getScenario().getName();
			Utils.print("Inicio-" + nome.replace(" ", "_").toUpperCase());
		}
	} 
		
	@After
	public void afterScenario(){
		if(tags.contains("@api")) {
			System.out.println("Finalizando os testes da API");
		}
		else {
			System.out.println("Finalizando os testes");
			String nome = Hooks.getScenario().getName();
			Utils.print("Final-" + nome.replace(" ", "_").toUpperCase());
			DriverFactory.killDriver();
		}
	}

}
