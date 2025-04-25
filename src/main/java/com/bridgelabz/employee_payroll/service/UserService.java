package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.*;
import com.bridgelabz.employee_payroll.model.User;
import com.bridgelabz.employee_payroll.repositories.UserRepository;
import com.bridgelabz.employee_payroll.util.JwtUtility;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private JwtUtility jwtUtility;
  //  @Autowired
    //private RabbitMQProducer rabbitMQProducer;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);


    /*
      Registers a new user if the email does not already exist.

      @param registerDTO Data Transfer Object containing full name, email, and password of the user.
      @return ResponseDto with a message and the result of the registration process.
     */

    @Override
    public ResponseDto<String, String> registerUser(RegisterDTO registerDTO) {
        log.info("Registering user: {}", registerDTO.getEmail());
        ResponseDto<String, String> res = new ResponseDto<>();

        if (existsByEmail(registerDTO.getEmail())) {
            log.warn("Registration failed: User already exists with email {}", registerDTO.getEmail());
            res.setMessage("error");
            res.setData("User Already Exists");
            return res;
        }
        User user = new User();
        user.setFullname(registerDTO.getFullName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        log.info("User {} registered successfully!", user.getEmail());

        emailService.sendEmail(user.getEmail(), "Registered in Employee Payroll App", "Hii "
                + "\n You have been successfully registered");

        res.setMessage("message");
        res.setData("User Registed Successfully");
        return res;
    }

   // public class UserService implements UserInterface {

    /*
      Logs in a user by validating email and password.

      @param loginDTO Data Transfer Object containing email and raw password for login.
      @return ResponseDto with a message and token on successful login.
     */
        @Override
        public ResponseDto<String, String> loginUser(LoginDTO loginDTO) {
            log.info("Login attempt for user: {}", loginDTO.getEmail());
            ResponseDto<String, String> res = new ResponseDto<>();
            Optional<User> userExists = getUserByEmail(loginDTO.getEmail());

            if (userExists.isPresent()) {
                User user = userExists.get();
                if (matchPassword(loginDTO.getPassword(), user.getPassword())) {
                    String token = jwtUtility.generateToken(user.getEmail());
                    user.setToken(token);
                    userRepository.save(user);
                    log.debug("Login successful for user: {}- Token generated", user.getEmail());
                    emailService.sendEmail(user.getEmail(), "Logged in Employee Payroll App", "Hii"
                            + "\n You have been successfully logged in!" + token);
                    res.setMessage("message");
                    res.setData("User Logged In Successfully: " + token);
                    return res;

                } else {
                    log.warn("Invalid credentials for user: {}", loginDTO.getEmail());
                    res.setMessage("error");
                    res.setData("Invalid Credentials");
                    return res;
                }

            } else {
                log.error("User not found with email: {}", loginDTO.getEmail());
                res.setMessage("error");
                res.setData("User Not Found");
                return res;
            }
        }

    /*
      Checks if a raw password matches the encoded password.

      @param rawPassword  Plain-text password entered by the user.
      @param encodedPassword Hashed password stored in the database.
      @return true if passwords match; false otherwise.
     */
        @Override
        public boolean matchPassword(String rawPassword, String encodedPassword) {
            log.debug("Matching password for login Attempt");
            return passwordEncoder.matches(rawPassword, encodedPassword);
        }

    /*
      Checks if a user already exists by email.

      @param Email address to check.
      @return true if user exists; false otherwise.
     */
        @Override
        public boolean existsByEmail(String email) {
            log.debug("Checking if user exists by email: {}", email);
            return userRepository.findByEmail(email).isPresent();
        }

    /*
      Retrieves a user by email.

      @param Email address of the user.
      @return Optional containing the user if found; empty otherwise.
     */
        @Override
        public Optional<User> getUserByEmail(String email) {
            log.debug("Fetching user by email: {}", email);
            return userRepository.findByEmail(email);
        }

    @Override
    public ResponseDto<String, String> forgotPassword(ForgotPasswordDto forgotPasswordDto){
        User user = userRepository.findByEmail(forgotPasswordDto.getEmail()).orElse(null);
        if (user == null){
            return new ResponseDto("error", "User not found");
        }

        String otp = generateOTP();

        user.setOtp(otp);
        userRepository.save(user);

        String subject = "Your OTP for Password Reset";
        String body = "Your OTP is : " + otp + ". Please use this to reset your password.";
        emailService.sendEmail(user.getEmail(), subject, body);

        return new ResponseDto("success", "OTP sent to mail.");
    }

    private  String generateOTP(){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Override
    public ResponseDto<String, String> resetPassword(ResetPasswordDto resetPasswordDto) {
        Optional<User> optionalUser = userRepository.findByEmail(resetPasswordDto.getEmail());

        if (optionalUser.isEmpty()) {
            return new ResponseDto<>("error", "User not found");
        }

        User user = optionalUser.get();

        if (!user.getOtp().equals(resetPasswordDto.getOtp())) {
            return new ResponseDto<>("error", "Invalid OTP");
        }

        user.setPassword(passwordEncoder.encode(resetPasswordDto.getNewPassword()));
        user.setOtp(null); // Clear OTP after reset
        userRepository.save(user);

        return new ResponseDto<>("message", "Password reset successful");
    }


}



