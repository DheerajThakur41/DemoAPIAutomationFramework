package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.base.UserProfileManagementService;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test(description = "Get Profile Test")
    public void getProfileTest(){
        AuthService authService=new AuthService();
        Response response = authService.login(new LoginRequest("uday1234", "uday1234"));
        String token = response.as(LoginResponse.class).getToken();

        UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
        response = userProfileManagementService.getProfile(token);
        GetProfileResponse profile = response.as(GetProfileResponse.class);
        Assert.assertEquals(profile.getFirstName(),"Raj");
    }
}
