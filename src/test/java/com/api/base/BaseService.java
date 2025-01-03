package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class BaseService {
    //Handle Base uri
    //Creating Request
    //Handeling Respose
    private static final String BASE_URL="http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        this.requestSpecification= given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endPoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
    }

    protected Response putRequest(Object payload, String endPoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer "+token);
    }

    protected Response getRequest(String endPoint){
        return requestSpecification.get(endPoint);
    }

}
