package com.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SignupRequest {
    private String username, password, email, firstName, lastName, mobileNumber;

    public static class Builder{
        private String username, password, email, firstName, lastName, mobileNumber;

        public Builder userName(String username){
            this.username=username;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber=mobileNumber;
            return this;
        }
        public SignupRequest build(){
            return new SignupRequest(username, password, email, firstName, lastName, mobileNumber);
        }
    }
}
