package com.api.steps;

import static com.api.util.Constans.URL_API;
import static org.junit.Assert.assertEquals;

import com.api.core.RequestManager;
import com.api.entities.Project;
import com.api.manage.ProjectManager;
import cucumber.api.TypeRegistry;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectSteps {

  private Project project;
  private String endPoint;
  private Response response;
  ProjectManager projectManager;
  public ProjectSteps(Project project){
    this.project = project;
  }

  @Given("I have the {string} endpoint")
  public void haveTheEndpoint(String endpoint) {
    this.endPoint = String.format(URL_API, endpoint);
    projectManager = new ProjectManager();
  }

  @When("I send a POST request the following values:")
  public void sendAPOSTRequestTheFollowingValues(Map<String, String> registry) {
    project = Project.createProject(registry);
    response= projectManager.createProjects(Project.createProject(registry));
   // System.out.println(newP.getId());
//    for (List<String> columns : rows) {
//      result.put(columns.get(0), columns.get(1));
//    }
//projectManager.getProjects();
    System.out.println(projectManager.getProjects());
   // response= RequestManager.postRequest(endPoint,null);

    //response = RequestManager.getRequest(endPoint);

//    List<String> tes = response.body().jsonPath().getList("id");
    //  response.path()
//
//    System.out.println(tes);


  }

  @Then("I expect the status code as {int}")
  public void expectTheStatusCodeAs(int expectedStatusCode) {
    int actualStatus = response.getStatusCode();
    assertEquals(String.format("The Expect Value is: '%s' But the Actual value is : '%s'",
        expectedStatusCode, actualStatus), expectedStatusCode, actualStatus);
  }

  public Project getProject() {
    return project;
  }
}
