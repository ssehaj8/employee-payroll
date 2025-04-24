package com.bridgelabz.employee_payroll.dto;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public @Data class LoginDTO{
    @NotBlank(message = "Email cannot be Empty")
    @Email(message= "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min=6, message ="Password must be at least 6 characters long" )
    private String password;


}
