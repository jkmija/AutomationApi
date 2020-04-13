Feature: Todoist CRUD

  @RemoveProjectCreated
  Scenario: Create a new project on todoist page
    Given I have the "projects" endpoint
    When I send a POST request the following values:
        | name                       |wacht movies |
#      | comment_count | 0                          |
#      | order         | 1                          |
    Then  I expect the status code as 200