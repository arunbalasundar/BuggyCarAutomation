package Step;

import Pages.HomePage;
import Pages.RegisterPage;

import io.cucumber.java.en.*;

public class RegisterSteps {
	HomePage home = new HomePage();
	RegisterPage register = new RegisterPage();
		
	@When("user clicks on Register link")
	public void gotoregister() throws InterruptedException {			
		home.clickregister();  
	}
	@When("user clicks on Register button")
	public void register() throws InterruptedException {			
		register.clickregister();  
	}	
    @And("user enters correct registration fields")
    public void enterdetails() throws InterruptedException {			
		register.enterdetails();  
	}    
    @And("user enters incorrect registration fields")
    public void enterdetails1() throws InterruptedException {			
		register.enterdetails1();  
	} 
    @Then("user should be successfully registered")
    public void verifylogin() throws InterruptedException {					
    	register.verifyregister();  
	}
    @Then("user should not be successfully registered")
    public void verifylogin1() throws InterruptedException {			
		register.verifyregister();  
	}      
 }
 