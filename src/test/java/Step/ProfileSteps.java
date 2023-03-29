package Step;

import Pages.HomePage;
import Pages.ProfilePage;
import Pages.RegisterPage;

import io.cucumber.java.en.*;

public class ProfileSteps {
	HomePage home = new HomePage();
	RegisterPage register = new RegisterPage();
	ProfilePage profile = new ProfilePage();
		
	@Given("user is logged in")
	public void login() throws InterruptedException {			
		home.go_to_homepage();  
		home.entercorrectdetails();    
		home.clicklogin();  
		home.verifylogin();    
	}
	@When("user changes basic information")
	public void enterchanges() throws InterruptedException {			
		profile.enterchanges();  
	}
	@When("user changes additional information")
	public void enterchanges1() throws InterruptedException {			
		profile.enterchanges1();  
	}
	@When("user changes password")
	public void changepassword() throws InterruptedException {			
		profile.enterchanges2();  
	}
	@And("user clicks Save")
	public void save() throws InterruptedException {			
		profile.clicksave();  
	}
	@When("user enters updated password")
	public void enterdetails() throws InterruptedException {			
		home.entercorrectdetails1();  
	}
	@When("user selects a model")
	public void selectmodel() throws InterruptedException {
		profile.selectmodel();
	}
	@And("user adds a comment")
	public void addcomment() throws InterruptedException {
		profile.addcomment();
	}
	@And("user clicks vote")
	public void clickvote() throws InterruptedException {
		profile.clickvote();
	}
	@Then("user vote is added")
	public void verifyvote() throws InterruptedException {
		profile.verifyvote();
	}
	@Then("user clicks on Profile")
	public void clickprofile() throws InterruptedException {			
		profile.clickprofile();  
	}
	@Then("changes should be successfully saved")
	public void verifychanges() throws InterruptedException {			
		profile.verifychanges();  
	}
         
 }
 