package com.api.steps;

import static com.api.util.Constans.URL_API;
import static org.junit.Assert.assertEquals;

import com.api.core.RequestManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.util.Map;

public class ProjectSteps {

  private String endPoint;
  private Response response;

  @Given("I have the {string} endpoint")
  public void haveTheEndpoint(String endpoint) {
    this.endPoint = String.format(URL_API, endpoint);
  }

  @When("I send a POST request the following values:")
  public void sendAPOSTRequestTheFollowingValues(Map<String, String> parameters) {
   // parameters.clear();
  response = RequestManager.postRequest(endPoint, parameters);
  }

  @Then("I expect the status code as {int}")
  public void expectTheStatusCodeAs(int expectedStatusCode) {
    int actualStatus = response.getStatusCode();
    assertEquals(String.format("The Expect Value is: '%s' But the Actual value is : '%s'",
        expectedStatusCode, actualStatus), expectedStatusCode, actualStatus);
  }
}
