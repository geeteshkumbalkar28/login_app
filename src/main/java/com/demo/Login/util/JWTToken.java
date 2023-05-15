package com.demo.Login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTToken {
    private final String SECRET = "OpticalLogin";
    public String createToken(String userLogin){
        String token;
        token = JWT.create().withClaim("userLogin",userLogin).sign(Algorithm.HMAC256(SECRET));
        return token;
    }
    public String decodeToken(String token){
        String userLogin = null;
        if(token != null){
            userLogin=JWT.require(Algorithm.HMAC256(SECRET))
                    .build().verify(token)
                    .getClaim("userLogin").asString();
        }return userLogin;
    }
}
