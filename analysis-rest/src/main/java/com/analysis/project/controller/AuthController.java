package com.analysis.project.controller;



import com.analysis.project.enums.GenderType;
import com.analysis.project.enums.RoleType;
import com.analysis.project.model.User;
import com.analysis.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    public record AuthResponse(Long id, String name,String surname,Integer month,GenderType gender,String role) {
    }

    private record LoginRequest(String tc, String password) {
    }

    private record SignUpRequest(String tc, String surname, String password, String name, String email, Integer month,
                                 GenderType gender) {
    }

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = Optional.ofNullable(userService.validTcAndPassword(loginRequest.tc, loginRequest.password).orElseThrow(() -> new RuntimeException("tc or password")));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(user.getId(), user.getName(),user.getSurname(),user.getMonth(),user.getGender(), user.getRole().toString()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        if (userService.hasUserWithTc(signUpRequest.tc)) {
            throw new RuntimeException(String.format("Username %s is already been used", signUpRequest.tc));
        }
        if (userService.hasUserWithEmail(signUpRequest.email)) {
            throw new RuntimeException(String.format("Email %s is already been used", signUpRequest.email));
        }

        User user = userService.saveUser(createUser(signUpRequest));
        return new AuthResponse(user.getId(), user.getName(),user.getSurname(),user.getMonth(),user.getGender(), user.getRole().toString());
    }

    private User createUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setTc(signUpRequest.tc);
        user.setPassword(signUpRequest.password);
        user.setName(signUpRequest.name);
        user.setSurname(signUpRequest.surname);
        user.setEmail(signUpRequest.email);
        user.setMonth(signUpRequest.month);
        user.setGender(signUpRequest.gender);
        user.setRole(RoleType.USER);
        return user;
    }
}