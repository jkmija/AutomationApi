package com.api.manage;

import static com.api.core.RequestManager.ACCESS_TOKEN;
import static com.api.util.Constans.URL_API;
import static io.restassured.RestAssured.given;

import com.api.core.Authentication;
import com.api.core.RequestManager;
import com.api.entities.Project;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.security.ec.point.ProjectivePoint;

public class ProjectManager {
public static final String ENDPOINT = String.format(URL_API, "projects");
  public static RequestSpecification REQUEST = Authentication.getInstance()
      .getRequestSpecification();
  private Project project;

  public ProjectManager() {

  }

public Response createProjects(Project project){
this.project = project;
 return given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).params(project.projectToMap()).when().post(ENDPOINT);
  }

public List<Project> getProjects(){
return
      Arrays.asList(given().contentType("application/json").auth().preemptive()
          .oauth2(ACCESS_TOKEN).spec(REQUEST).when().get(ENDPOINT).then()
          .statusCode(200)
          .extract()
          .as(Project[].class));
//  return
//      given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).when().get(ENDPOINT).then().assertThat().statusCode(200).extract().asString();

}

public Response deleteProject (Project project){
  System.out.println(ENDPOINT+"/"+getId(project));
    return RequestManager.deleteRequest(ENDPOINT+"/"+getId(project));
}

public long getId(Project project){

  for (Project proj: getProjects()) {
    if (project.getName().equals(proj.getName())){
      return proj.getId();
    }
  }
  return 0;
}
}
