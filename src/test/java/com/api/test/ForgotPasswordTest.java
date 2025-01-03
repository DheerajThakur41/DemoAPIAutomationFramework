package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Check if forgot password work")
    public void fogotPasswordTest() {
        AuthService authService = new AuthService();
        Response resp = authService.forgetPassword("testautomationacademy33@gmail.com");
        Assert.assertEquals(resp.jsonPath().getString("message"),"If your email exists in our system, you will receive reset instructions.");
    }
}
