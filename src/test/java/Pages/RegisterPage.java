package Pages;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Step.driverandannotations.driver;

import java.time.Duration;
import java.util.Date;


public class RegisterPage {
	
	//Locators
	By txtfirstname = By.xpath("//input[@name='firstName']");
	By txtlastname = By.xpath("//input[@name='lastName']");
	By txtlogin = By.xpath("//input[@name='username']");
	By txtpassword = By.xpath("//label/following::input[@name='password']");
	By txtcpassword = By.xpath("//input[@name='confirmPassword']");
	By btncancel = By.xpath("//button[contains(text(),'Cancel')]");
	By btnregister = By.xpath("//button[contains(text(),'Register')]");
	By lblregister = By.xpath("//div[@class='result alert alert-success']");
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    
	//Methods
	
	public void verifyregister() throws InterruptedException {
		Thread.sleep(3000);	
		try{
			driver.findElement(lblregister).isDisplayed();
			Thread.sleep(3000);	
			Assert.assertTrue(driver.findElement(lblregister).getText().equals("Registration is successful"));
		}catch(Exception e) {
			System.out.println("Registration not succcessful");
		}
	}
	
	public void clickregister() throws InterruptedException {
		driver.findElement(btnregister).click();
		Thread.sleep(3000);		
	}
	
	public void enterdetails() throws InterruptedException {			
		driver.findElement(txtfirstname).sendKeys("test");
		driver.findElement(txtlastname).sendKeys("test");
		Date date = new Date();
		long timeMilli = date.getTime();
		driver.findElement(txtlogin).sendKeys("a"+timeMilli);		
		driver.findElement(txtpassword).sendKeys("A123456789a!");
		driver.findElement(txtcpassword).sendKeys("A123456789a!");
		Thread.sleep(2000);
		driver.findElement(btnregister).click();
	}
	public void enterdetails1() throws InterruptedException {			
		driver.findElement(txtfirstname).sendKeys("df");
		driver.findElement(txtlastname).sendKeys("sdf");
		driver.findElement(txtlogin).sendKeys("test");
		driver.findElement(txtpassword).sendKeys("A123456789a!");
		driver.findElement(txtcpassword).sendKeys("A123456789a!");
		Thread.sleep(2000);
		driver.findElement(btnregister).click();
	}
}
