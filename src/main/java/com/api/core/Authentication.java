package com.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Authentication {

  private static final String TOKEN_HEADER = "OAuth 2.0";
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
    requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation().build();
  }

  public RequestSpecification getRequestSpecification(){
    return requestSpecification;
  }

}
