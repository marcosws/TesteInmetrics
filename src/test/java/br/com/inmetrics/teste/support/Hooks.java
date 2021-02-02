package br.com.inmetrics.teste.support;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static Scenario scenario;

	public static Scenario getScenario() {
		return scenario;
	}

	@Before
	public void beforeScenario(Scenario scenario){
		System.out.println("RODANDO A APLICAÇÃO");
		
		//System.out.println(Hooks.getScenario().getName());
		//Collection<String> tags = Hooks.getScenario().getSourceTagNames();
		//tags.forEach(System.out::println);
		
		
		
		Hooks.scenario = scenario;
		DriverFactory.setDriver(Browser.CHROME);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(Context.INMETRICS_APP);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	} 
		
	@After
	public void afterScenario(){
		System.out.println("FINALIZANDO A APLICAÇÃO");
		//DriverFactory.killDriver();
	}

}
