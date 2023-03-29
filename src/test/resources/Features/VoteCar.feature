
@VoteScenario
Feature: Vote for a model in the Buggy Cars website
		 
@VTC1
Scenario Outline: Verify user can successfully vote for a model with comments
		 Given user is logged in
		 When user selects a model
		 And user adds a comment
		 And user clicks vote
		 Then user vote is added 
		 
@VTC2
Scenario Outline: Verify user can successfully vote for a model without comments
		 Given user is logged in
     When user selects a model
		 And user clicks vote		 
		 Then user should be successfully logged in 