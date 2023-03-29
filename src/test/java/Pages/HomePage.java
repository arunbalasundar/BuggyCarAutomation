package Pages;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Comparators;

import static Step.driverandannotations.driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage {
		
	//Locators
	By txtusername = By.xpath("//input[@name='login']");
	By txtpassword = By.xpath("//input[@name='password']");
	By btnlogin = By.xpath("//button[contains(text(),'Login')]");
	By lnkregister = By.xpath("//a[contains(text(),'Register')]");
	By lnkhome = By.xpath("//a[text()='Buggy Rating']");
	By lnkprofile = By.xpath("//a[@class='nav-link' and contains(text(),'Profile')]");
	By lnklogout = By.xpath("//a[@class='nav-link' and contains(text(),'Logout')]");
	By lnkname = By.xpath("//span[@class='nav-link disabled' and contains(text(),'Hi')]");
	By lblwarning = By.xpath("//span[@class='label label-warning']");
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    
	//Methods
	
	public void go_to_homepage() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(lnkhome).click();
	}
	
	public void entercorrectdetails() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(txtusername).sendKeys("test12");
		driver.findElement(txtpassword).sendKeys("A123456789a!");
	}
	
	public void entercorrectdetails1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(txtusername).sendKeys("test12");
		driver.findElement(txtpassword).sendKeys("B123456789b!");
	}
	
	public void enterincorrectdetails() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(txtusername).sendKeys("asff");
		driver.findElement(txtpassword).sendKeys("af");
	}
	
	public void showwarning() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(lblwarning).isDisplayed();
		Assert.assertTrue(driver.findElement(lblwarning).getText().equals("Invalid username/password"));		
	}
	
	public void clicklogin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(btnlogin).click();
	}
	
	public void clickregister() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(lnkregister).click();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://buggy.justtestit.org/register"));
	}
	
	public void verifylogin() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://buggy.justtestit.org/"));
		try {
		if(driver.findElement(lnkprofile).isDisplayed()==true) {
			driver.findElement(lnklogout).isDisplayed();
			driver.findElement(lnkname).isDisplayed();
			Assert.assertTrue("user is logged in",true);
		}			
		}catch(Exception e) {
			Assert.assertTrue("user is not logged in",true);
		}
	}
}
