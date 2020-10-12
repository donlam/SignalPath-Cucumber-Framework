Feature: Verify to do app can create and remove list

 Scenario: I can create a new to do list
 		Given I navigate to "http://todomvc.com/examples/angular2/"
        Then I enter "complete coding challenge" into input field having class "new-todo"
        Then I press the enter button
        Then element having class "todo-list" should have text as "complete coding challenge"

 Scenario: I can complete a to do list
        Then I click on element having class "toggle"
        When I should have completed my list
        Then I should have "0" items left

#make it simple scenario with a single item in the to do list
 Scenario: I can delete a to do
        Then I can delete my last to do item
        Then element having class "todo-list" should not be present
 
 Scenario: Close browser
 		Then I close browser