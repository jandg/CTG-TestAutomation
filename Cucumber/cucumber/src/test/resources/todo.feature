Feature: Todo app actions
  As a user I should able perform actions on the Todo app.

  Scenario: Creating a todo
    Given I open the Todo app
    And I enter "Automation is fun!" into input field
    When I press 'Enter'
    Then a new todo entry is added
    And the text is "Automation is fun!"

  Scenario: Removing a todo
    Given I open the Todo app
    And I create 3 new todo entries
    When I remove a random todo entry
    Then there are 2 todo entries left
    And the removed todo entry is not present

  Scenario: Completing a todo
    Given I open the Todo app
    And I create 3 new todo entries
    When I complete the third todo entry
    Then the third todo entry has been completed
    And the number of completed todo entries is 1

  Scenario: Editing a todo
    Given I open the Todo app
    And I create 3 new todo entries
    When I edit the second todo entry
    And I change the text to "I used to be something else"
    Then the text of the second todo entry reads "I used to be something else"