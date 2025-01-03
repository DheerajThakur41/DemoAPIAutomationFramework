package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Check if update Profile working or not")
    public void updateProfileTest(){
        AuthService authService=new AuthService();
        Response response = authService.login(new LoginRequest("uday1234", "uday1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
        Response userProfiResponse = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println("Profile=>\n"+userProfiResponse.prettyPrint());
        GetProfileResponse userProfile = userProfiResponse.as(GetProfileResponse.class);
        Assert.assertEquals(userProfile.getUsername(),"uday1234");

        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName = faker.name().lastName();
        UpdateProfileRequest updateProfileReqPayload = UpdateProfileRequest.builder().firstName(firstName).lastName(lastName).email(userProfile.getEmail()).mobileNumber(userProfile.getMobileNumber()).build();
        response=userProfileManagementService.updateProfile(loginResponse.getToken(),updateProfileReqPayload);
        GetProfileResponse updateProfileResponse = response.as(GetProfileResponse.class);
        Assert.assertEquals(updateProfileResponse.getFirstName(),firstName);
        Assert.assertEquals(updateProfileResponse.getLastName(),lastName);
        System.out.println(response.prettyPrint());


    }
}
