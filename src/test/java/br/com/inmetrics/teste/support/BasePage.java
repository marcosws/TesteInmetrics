package br.com.inmetrics.teste.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private WebDriver driver;
	
	public BasePage() {
		this.driver = DriverFactory.getDriver();
	}
	
	/* Médotos Protegidos ======================================== */
	
	/**
	 * @author Marcos
	 */
	protected enum Atributo{
		ID, XPATH, TAG_NAME, NAME, CLASS_NAME, CSS_SELECTOR;
	}
	/**
	 * @author Marcos
	 * @param atributo
	 * @param valor
	 */
	protected void clicar(Atributo atributo, String valor) {
		WebElement webElement = this.recuperarElemento(atributo, valor);
		this.highLight(webElement);
		webElement.click();
	}
	/**
	 * @author Marcos
	 * @param atributo
	 * @param valor
	 * @param texto
	 */
	protected void editar(Atributo atributo, String valor, String texto) {
		WebElement webElement = this.recuperarElemento(atributo, valor);
		this.highLight(webElement);
		webElement.clear();
		webElement.sendKeys(texto);
	}
	

	protected void selecionar(Atributo atributo, String valor, boolean checked) {
		WebElement webElement = this.recuperarElemento(atributo, valor);
		this.highLight(webElement);
		if(checked != webElement.isSelected()) {
			webElement.click();
		}
	}
	
	protected void selecionar(Atributo atributo, String valor, String texto) {
		WebElement webElement = this.recuperarElemento(atributo, valor);
		Select select = new Select(webElement);
		this.highLight(webElement);
		select.selectByVisibleText(texto);
	}

	protected String recuperarTexto(Atributo atributo, String valor) {
		WebElement webElement = this.recuperarElemento(atributo, valor);
		this.highLight(webElement);
		return webElement.getText();
	}
	
	/**
	 * @author Marcos
	 * @param atributo
	 * @param valor
	 * @param timeOutSegundos
	 * @return
	 */
	protected boolean aguardar(Atributo atributo, String valor, int timeOutSegundos) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutSegundos);
		WebElement webElement = null;
		try {
			if(atributo.equals(Atributo.ID)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(valor)));
			}
			else if(atributo.equals(Atributo.CLASS_NAME)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(valor)));
			}
			else if(atributo.equals(Atributo.NAME)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(valor)));
			}
			else if(atributo.equals(Atributo.TAG_NAME)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(valor)));
			}
			else if(atributo.equals(Atributo.XPATH)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(valor)));
			}
			else if(atributo.equals(Atributo.CSS_SELECTOR)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(valor)));
			}
		}
		catch(Exception e) {
			return false;
		}
		return webElement.isDisplayed();
	}
	
	/* Métodos Privados ========================================== */
	
	/**
	 * @author Marcos
	 * @param atributo
	 * @param valor
	 * @return
	 */
	private WebElement recuperarElemento(Atributo atributo, String valor) {
		
		switch(atributo) {
			case ID:
				return driver.findElement(By.id(valor));
			case XPATH:
				return driver.findElement(By.xpath(valor));
			case TAG_NAME: 
				return driver.findElement(By.tagName(valor));
			case NAME: 
				return driver.findElement(By.name(valor));
			case CLASS_NAME:
				return driver.findElement(By.className(valor));
			case CSS_SELECTOR:
				return driver.findElement(By.cssSelector(valor));
		}
		return null;
		
	}
    private void highLight(WebElement webElement) {
	    String script = "arguments[0].setAttribute('style', arguments[1]);";
	    String arguments = "color: white; border: 2px solid rgb(109,254,48); text-shadow: 1px 1px rgb(48,156,1);";
	    for (int i = 0; i < 3; i++) {
			this.executeJavaScript(script, webElement, arguments);
			Utils.sleep(100);
			this.executeJavaScript(script, webElement);
			Utils.sleep(100);
	    }
    }
	private void executeJavaScript(String script, WebElement webElement, String arguments) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement, arguments);
	}
	private void executeJavaScript(String script, WebElement webElement) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement);
	}

}
