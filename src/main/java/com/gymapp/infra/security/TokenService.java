package com.gymapp.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gymapp.models.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(UserEntity user){

        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withIssuer("user")
                    .withSubject(user.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTVerificationException e){
            throw new RuntimeException("Error generating token ", e);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm)
                    .withIssuer("user")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTCreationException e){
            return "";
        }
    }
    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}