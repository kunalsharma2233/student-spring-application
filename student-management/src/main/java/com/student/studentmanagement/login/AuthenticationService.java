package com.student.studentmanagement.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("student");
        boolean isValidPassword = username.equalsIgnoreCase("student");
        return isValidUsername && isValidPassword;
    }
}
