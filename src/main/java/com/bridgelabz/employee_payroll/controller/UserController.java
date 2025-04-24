package com.bridgelabz.employee_payroll.controller;
import com.bridgelabz.employee_payroll.dto.LoginDTO;
import com.bridgelabz.employee_payroll.dto.RegisterDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
   Register a new user.
   @param registerDTO - DTO containing user registration details.
   @return ResponseEntity with success or error message and appropriate HTTP status.
   */
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        ResponseDto responseDTO = userService.registerUser(registerDTO);
        return new ResponseEntity<>(responseDTO,
                responseDTO.getMessage().equals("error") ? HttpStatus.CONFLICT : HttpStatus.CREATED);
    }


    /*
    Login an existing user.
    @param loginDTO - DTO containing login credentials.
    @return ResponseEntity with token or error message and appropriate HTTP status.
    */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        ResponseDto responseDTO = userService.loginUser(loginDTO);
        return new ResponseEntity<>(responseDTO,
                responseDTO.getMessage().equals("error") ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }
}

