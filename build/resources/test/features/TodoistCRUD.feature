Feature: Todoist CRUD

  Scenario: Create a new proyect on todoist page
    Given I have the "Project" endpoint
    When I send a POST request the following values:
      | Name          | Movies to watch |
#      | Comment_count | 0               |
#      | Order         | 1               |
    Then  I expect the status code as 200