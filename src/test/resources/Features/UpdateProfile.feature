
@UpdateScenario
Feature: Update profile flow in Buggy Cars Website

@PTC1
Scenario Outline: Verify user can successfully update basic details
		 Given user is logged in
		 Then user clicks on Profile
		 When user changes basic information
		 And user clicks Save
		 Then changes should be successfully saved 
		 
@PTC2
Scenario Outline: Verify user can successfully update additional details
		 Given user is logged in
		 Then user clicks on Profile
		 When user changes additional information
		 And user clicks Save
		 Then changes should be successfully saved 
		 
@PTC3
Scenario Outline: Verify user can save details without changing information
		 Given user is logged in
		 Then user clicks on Profile	
		 And user clicks Save
		 Then changes should be successfully saved 