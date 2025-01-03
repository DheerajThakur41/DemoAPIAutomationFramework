package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService {
    private static final String BASE_PATH="/api/auth/";

    public Response login(LoginRequest paylaod){
        return postRequest(paylaod,BASE_PATH+"login");
    }

    public Response signUp(SignupRequest paylaod){
        return postRequest(paylaod,BASE_PATH+"signup");
    }

    public Response forgetPassword(String emailAddress){
        HashMap<String,String> payload=new HashMap<>();
        payload.put("email",emailAddress);
        return postRequest(payload,BASE_PATH+"forgot-password");
    }

}
