package com.api.models.response;

import lombok.Data;

@Data
public class GetProfileResponse {
    private String username, email, firstName, lastName, mobileNumber;
    private Integer id;
}
