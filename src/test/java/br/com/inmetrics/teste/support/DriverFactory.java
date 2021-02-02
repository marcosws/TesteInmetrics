package br.com.inmetrics.teste.support;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class DriverFactory {
	
	
	private static WebDriver driver = null;

	/**
	 * @author Marcos
	 * @return
	 * - Recupera o WebDriver
	 */
	public static WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * @author Marcos
	 * @param browser
	 * - Atribui o WebDriver conforme o Browser selecionado EX: .setDriver(Browser.IE);
	 */
	public static void setDriver(Browser browser) {
		
 		switch(browser){
		case IE:
			System.setProperty("webdriver.ie.driver", getPathDriver(browser));
			driver = new InternetExplorerDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", getPathDriver(browser));
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", getPathDriver(browser));
			driver = new ChromeDriver();
			break;
		case OPERA:
			System.setProperty("webdriver.opera.driver", getPathDriver(browser));
			driver = new OperaDriver();
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", getPathDriver(browser));
			driver = new EdgeDriver();
			break;
 		}
		
	}
	
	/**
	 * @author Marcos
	 * 
	 */
	public static void killDriver() {
		driver.quit();
	}
	
	/**
	 * @author Marcos
	 * @param browser
	 * @return
	 */
	private static String getPathDriver(Browser browser) {
		
		String userPath = System.getProperty("user.dir") + "//src//test//resources//drivers";
 		switch(browser){
		case IE:
			return userPath += "//IEDriverServer.exe";
		case FIREFOX:
			return userPath += "//geckodriver.exe";
		case CHROME:
			return userPath += "//chromedriver.exe";
		case OPERA:
			return userPath += "//operadriver.exe";
		case EDGE:
			return userPath += "//msedgedriver.exe";			
 		}
		return userPath += "//IEDriverServer.exe";
		
	}




}
