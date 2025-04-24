package com.bridgelabz.employee_payroll.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class RegisterDTO{

    @NotBlank(message = "Full name cannot be empty")
    @Size(min=3, message = "Full Name must be min 3 character long")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Name must start with a Capital letter and Contain only letters")
    private String fullName;

    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;

    @NotBlank(message = "Password cannot be empty" )
    @Size(min=6, message = "Password must be at least 6 characters long")
    //@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,}$",
            // message = "Password must have at 6 characters, 1 uppercase letter, and 1 digit")
    private String password;
}