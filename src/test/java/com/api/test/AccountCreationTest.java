package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "create Account Test")
    public void createAccountTest(){
        Faker faker = new Faker();

        SignupRequest signupRequest= new SignupRequest.Builder()
                .userName(faker.name().username())
                .email(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .password("r122345")
                .mobileNumber(faker.phoneNumber().subscriberNumber(10)).build();

        System.out.println("User: "+signupRequest.toString());

        AuthService authService=new AuthService();
        Response r = authService.signUp(signupRequest);
        Assert.assertEquals(r.prettyPrint(),"User registered successfully!");
    }
}
