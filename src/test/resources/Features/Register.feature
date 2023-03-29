
@RegisterScenario
Feature: Register flow in Buggy Cars Website

@RTC1
Scenario Outline: Verify user can successfully register into buggy cars website
		 Given user is in homepage
		 When user clicks on Register link
		 And user enters correct registration fields
		 Then user should be successfully registered 
		 
@RTC2
Scenario Outline: Verify user registration with incorrect details
		 Given user is in homepage
		 When user clicks on Register link
		 And user enters incorrect registration fields
		 Then user should not be successfully registered 


#"This case is now working manually without issue, when executed at the time of writing Critical Bug Report - It was failing manually"
#ignore if working now
@RTC3
Scenario Outline: Verify user registration with login fields entered
		 Given user is in homepage
		 When user clicks on Register link
		 And user enters correct login fields
		 When user clicks on Register button 
		 And user enters correct registration fields
		 Then user should not be successfully registered 
		 