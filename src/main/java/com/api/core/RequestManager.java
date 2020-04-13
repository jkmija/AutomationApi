package com.api.core;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sun.security.ec.point.ProjectivePoint;

import java.util.HashMap;
import java.util.Map;

public class RequestManager {
   public static final String ACCESS_TOKEN = "7961b447dee6e4ffc9e97a466d850f8e06b238bb";

  public static RequestSpecification REQUEST = Authentication.getInstance()
      .getRequestSpecification();


  public static Response getRequest(final String endpoint) {
    get("").then().assertThat().statusCode(200).extract().as(ProjectivePoint.class);
      return given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).when().get(endpoint);

  }

  public static Response postRequest(final String endpoint, final Map<String, ?> parameters) {
    Map<String, Object> t =  new HashMap<>();
    t.put("name","2121asdadasdsadkk");
    return given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).params(t).when().post(endpoint);
  }

  public static Response putRequest(final String endpoint, final Map<String, Object> parameters) {
    return given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).params(parameters)
        .when().put(endpoint);
  }

  public static Response deleteRequest(final String endpoint) {
    return given().auth().preemptive().oauth2(ACCESS_TOKEN).spec(REQUEST).when().delete(endpoint);
  }


}
