
@LoginScenario
Feature: Login flow in Buggy Cars Website

@LTC1
Scenario Outline: Verify user can login with correct details as existing user
     Given user is in homepage
     When user enters correct login fields
     And user clicks on login button		 
		 Then user should be successfully logged in 
		 	 
@LTC2
Scenario Outline: Verify user login with incorrect details
		 Given user is in homepage		 
		 When user enters incorrect login fields
		 And user clicks on login button
		 Then user gets warning for incorrect details
		 Then user should not be logged in 

@LTC3
Scenario Outline: Verify empty user login
		 Given user is in homepage
		 And user clicks on login button		 
		 Then user should not be logged in 
		 		 