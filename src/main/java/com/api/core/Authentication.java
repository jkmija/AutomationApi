package com.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Authentication {

  private static final String TOKEN_HEADER = "X-TrackerToken";
  private static Authentication instance;
  private RequestSpecification requestSpecification;

  private Authentication (){
    initApi();
  }

  public static Authentication getInstance(){
    if (instance == null){
      instance = new Authentication();
    }
    return instance;
  }

  private void initApi(){
    requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation().addHeader(TOKEN_HEADER,"7961b447dee6e4ffc9e97a466d850f8e06b238bb").build();
  }

  public RequestSpecification getRequestSpecification(){
    return requestSpecification;
  }

}
