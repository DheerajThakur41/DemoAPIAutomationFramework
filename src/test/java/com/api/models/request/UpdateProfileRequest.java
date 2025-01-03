package com.api.models.request;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class UpdateProfileRequest {
    private String  firstName, lastName, email, mobileNumber;
}
