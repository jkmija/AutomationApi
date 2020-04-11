package com.api.core;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RequestManager {

  public static RequestSpecification REQUEST = Authentication.getInstance()
      .getRequestSpecification();


  public static Response getRequest(final String endpoint) {
    return given().spec(REQUEST).when().get(endpoint);
  }

  public static Response postRequest(final String endpoint, final Map<String, String> parameters) {
    return given().spec(REQUEST).params(parameters).when().post(endpoint);
  }

  public static Response putRequest(final String endpoint, final Map<String, Object> parameters) {
    return given().spec(REQUEST).params(parameters)
        .when().put(endpoint);
  }

  public static Response deleteRequest(final String endpoint) {
    return given().spec(REQUEST).when().delete(endpoint);
  }
}
