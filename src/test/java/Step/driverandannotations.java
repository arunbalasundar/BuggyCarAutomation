package Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;

public class driverandannotations {
	public static WebDriver driver;


	public WebDriver getDriver() {
		return this.getDriver();
	}
	public void setDriver(WebDriver driver) {
	    this.driver = driver;
	}
	@Before
	public void before() throws InterruptedException{  		  
	   System.setProperty("webdriver.chrome.driver", "chromedriver");	
	   
	   //To run test in firefox// 
	   
	   //System.setProperty("webdriver.gecko.driver",Path_of_Firefox_Driver");
	   //WebDriver driver = new FirefoxDriver();	   
	   ChromeOptions options = new ChromeOptions();	  
	   options.addArguments("start-maximized");
	   options.addArguments("--window-size=1920, 1080"); 
	   //options.addArguments("--headless");     
	   options.addArguments("--remote-allow-origins=*");
	   driver = new ChromeDriver(options);	   
	   //driver = new ChromeDriver();	    
	   //driver.get(System.getenv("URL"));
	   driver.get("https://buggy.justtestit.org");
	   Thread.sleep(4000);
	}
}
