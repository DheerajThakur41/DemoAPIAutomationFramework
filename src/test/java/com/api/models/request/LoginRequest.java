package com.api.models.request;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class LoginRequest {
        public String username;
        public String password;
}
