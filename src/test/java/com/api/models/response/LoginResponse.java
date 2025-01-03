package com.api.models.response;


import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String token,type,username,email;
    private Integer id;
    private List<String> roles;
}
