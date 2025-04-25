package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.*;
import com.bridgelabz.employee_payroll.model.User;

import java.util.Optional;

public interface UserInterface {

    /*
    Register a new user.
    @param registerDTO - DTO containing the user registration details.
    @return ResponseDto containing the message and data regarding the registration status.
    */
    ResponseDto registerUser(RegisterDTO registerDTO);

    /*
        Login an existing user.
        @param loginDTO - DTO containing user login credentials.
        @return ResponseDto containing the message and data regarding the login status.
        */
    ResponseDto loginUser(LoginDTO loginDTO);

    /*
    Match raw password with encoded password.
    @param rawPassword - The raw password entered by the user.
    @param encodedPassword - The password stored in the database (encoded).
    @return boolean - Returns true if the passwords match, false otherwise.
    */
    boolean matchPassword(String rawPassword, String encodedPassword);

    /*
    Check if a user exists by their email.
    @param email - The email of the user.
    @return boolean - Returns true if the user exists, false otherwise.
    */
    boolean existsByEmail(String email);

    /*
    Fetch user by email.
    @param email - The email of the user.
    @return Optional<User> - An Optional containing the User object if found, empty if not.
    */
    Optional<User> getUserByEmail(String email);

    ResponseDto forgotPassword(ForgotPasswordDto forgotPasswordDto);

    ResponseDto<String, String> resetPassword(ResetPasswordDto resetPasswordDto);
}

