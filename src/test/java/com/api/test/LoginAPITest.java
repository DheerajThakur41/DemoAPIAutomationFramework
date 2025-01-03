package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listners.TestListener.class)
public class LoginAPITest {

    @Test(description = "Simple Test for Login")
    public void loginTest(){
        LoginRequest loginRequest=new LoginRequest("uday1234","uday1234");
        AuthService authService= new AuthService();
        Response r = authService.login(loginRequest);
        LoginResponse loginResponse =r.as(LoginResponse.class);

//        System.out.println("loginResponse Token ==>" +loginResponse.getToken());
//        System.out.println(r.prettyPrint());
//        System.out.println("Token from JsonPath=>"+r.jsonPath().getString("token"));
//        System.out.println("Status Code:"+r.statusCode());
        Assert.assertEquals(r.getStatusCode(),200);
    }
}
