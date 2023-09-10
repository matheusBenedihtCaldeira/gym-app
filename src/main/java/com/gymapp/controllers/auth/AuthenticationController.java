package com.gymapp.controllers.auth;

import com.gymapp.infra.security.TokenService;
import com.gymapp.models.entities.UserEntity;
import com.gymapp.models.requests.LoginRequest;
import com.gymapp.models.requests.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest){
        var user = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        var auth = this.authenticationManager.authenticate(user);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}