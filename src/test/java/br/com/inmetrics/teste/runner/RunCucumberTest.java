package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"json:target/cucumber.json"},
		features = {"src/test/resources/features/"},
		glue = {"br.com.inmetrics.teste.steps","br.com.inmetrics.teste.support"},
		tags = "@app"
		)
public class RunCucumberTest {
	

}