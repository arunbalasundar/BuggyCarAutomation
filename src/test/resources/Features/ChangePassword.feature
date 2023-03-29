
@ChangePasswordScenario
Feature: Change user password flow in Buggy Cars Website
		 
@CTC1
Scenario Outline: Verify user can successfully update password
		 Given user is logged in
		 Then user clicks on Profile
		 When user changes password
		 And user clicks Save
		 Then changes should be successfully saved
		 
@CTC2
Scenario Outline: Verify user can successfully login with updated password
		 Given user is in homepage
     When user enters updated password
     And user clicks on login button		 
		 Then user should be successfully logged in 