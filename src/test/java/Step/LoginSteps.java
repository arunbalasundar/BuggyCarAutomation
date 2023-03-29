package Step;

import Pages.HomePage;
import Pages.RegisterPage;

import io.cucumber.java.en.*;

public class LoginSteps {
	HomePage home = new HomePage();
	RegisterPage register = new RegisterPage();
	
	@Given("user is in homepage")
	public void home() throws InterruptedException {			
		home.go_to_homepage();  
	}	
	@When("user enters correct login fields")
	public void enterdetails() throws InterruptedException {			
		home.entercorrectdetails();  
	}
	@When("user enters incorrect login fields")
	public void enterincorrectdetails() throws InterruptedException {			
		home.enterincorrectdetails();  
	}	
	@Then("user gets warning for incorrect details")
	public void warning() throws InterruptedException {
		home.showwarning();
	}		
    @And("user clicks on login button")
    public void login() throws InterruptedException {			
		home.clicklogin();  
	}
    @Then("user should be successfully logged in")
    public void verifylogin() throws InterruptedException {			
		home.verifylogin();  
	}
    @Then("user should not be logged in")
    public void verifylogin1() throws InterruptedException {			
		home.verifylogin();  
	}      
 }
 