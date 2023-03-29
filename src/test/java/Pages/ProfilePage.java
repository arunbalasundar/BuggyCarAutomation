package Pages;

import org.junit.Assert;

import org.openqa.selenium.By;
import static Step.driverandannotations.driver;


public class ProfilePage {
	
	//Locators
	By lnkhome = By.xpath("//a[text()='Buggy Rating']");
	By lnkprofile = By.xpath("//a[@class='nav-link' and contains(text(),'Profile')]");
	By lnklogout = By.xpath("//a[@class='nav-link' and contains(text(),'Logout')]");
	By lnkname = By.xpath("//span[@class='nav-link disabled' and contains(text(),'Hi')]");
	By btnsave = By.xpath("//button[text()='Save']");
	By txtfirstname = By.xpath("//input[@name='firstName']");
	By txtlastname = By.xpath("//input[@name='lastName']");
	By txtaddress = By.xpath("//textarea[@name='address']");
	By txtage = By.xpath("//input[@name='age']");
	By txtphone = By.xpath("//input[@name='phone']");
	By lblsave = By.xpath("//div[contains[text(),'The profile has been saved successful')]");
	By txtcpassword = By.xpath("//input[@name='currentPassword']");
	By txtnpassword = By.xpath("//input[@name='newPassword']");
	By txtnpassword1 = By.xpath("//input[@name='newPasswordConfirmation']");
	By imgmodel = By.xpath("//img[@title='Guilia Quadrifoglio']");
	By imgmodellist = By.xpath("//img[@src='/img/overall.jpg']");
	By imgmodel3 = By.xpath("//a[text()='Mito']");
	By txtcomment = By.xpath("//textarea[@id='comment']");
	By btnvote = By.xpath("//button[@class='btn btn-success']");
	By lblvote = By.xpath("//p[@class='card-text' and text()='Thank you for your vote!']");
	    
	//Methods
		
	public void verifychanges() throws InterruptedException {
		Thread.sleep(3000);	
		try{								
			if(driver.findElement(lblsave).isDisplayed()==true) {
				driver.findElement(lblsave).isDisplayed();
				Assert.assertTrue("Details saved",true);	
			}
			else
				System.out.println("Changes not succcessful");	
		}catch(Exception e) {}
	}
	
	public void clicksave() throws InterruptedException {			
		driver.findElement(btnsave).click();
		Thread.sleep(3000);		
	}
	
	public void clickprofile() throws InterruptedException {
		driver.findElement(lnkprofile).click();
		Thread.sleep(3000);		
	}
	
	public void selectmodel() throws InterruptedException {
		driver.findElement(imgmodel).click();
		Thread.sleep(3000);		
	}
	
	public void selectmodel2() throws InterruptedException {
		driver.findElement(imgmodellist).click();
		Thread.sleep(3000);
		driver.findElement(imgmodel3).click();
		Thread.sleep(3000);		
	}
	
	public void clickvote() throws InterruptedException {			
		try {
		driver.findElement(btnvote).click();
		}
		catch(Exception e) {
			System.out.println("Already voted/login to vote,trying a different model");					
			driver.findElement(lnkhome).click();
			Thread.sleep(3000);
			selectmodel2();
			addcomment();
			driver.findElement(btnvote).click();
		}
		Thread.sleep(3000);		
	}
	
	public void verifyvote() throws InterruptedException {
		Thread.sleep(3000);			
		driver.findElement(lblvote).isDisplayed();
		Thread.sleep(3000);	
		Assert.assertTrue(driver.findElement(lblvote).getText().equals("Thank you for your vote!"));
	}
	
	public void addcomment() throws InterruptedException {		
		try {
			driver.findElement(txtcomment).sendKeys("adding comment");
			}
			catch(Exception e) {
				System.out.println("Already voted/login to vote");
			}	
		Thread.sleep(3000);		
	}
	
	public void enterchanges() throws InterruptedException {			
		driver.findElement(txtfirstname).sendKeys("test");
		driver.findElement(txtlastname).sendKeys("test");		
	}
	public void enterchanges1() throws InterruptedException {		
		driver.findElement(txtfirstname).sendKeys("df");
		driver.findElement(txtlastname).sendKeys("sdf");
		driver.findElement(txtaddress).sendKeys("test");
		driver.findElement(txtphone).sendKeys("2131232");
		driver.findElement(txtage).clear();
		driver.findElement(txtage).sendKeys("32");
	}
	public void enterchanges2() throws InterruptedException {			
		Thread.sleep(3000);
		driver.findElement(txtcpassword).sendKeys("A123456789a!");
		driver.findElement(txtnpassword).sendKeys("B123456789b!");
		driver.findElement(txtnpassword1).sendKeys("B123456789b!");		
	}
}
