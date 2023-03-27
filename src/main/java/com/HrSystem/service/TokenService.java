package com.HrSystem.service;

import io.jsonwebtoken.*;
import com.HrSystem.entity.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author hrq
 * @date 2023/03/26
 */


@Service
public class TokenService {

    // token有效期
    private static long time = 1000l*60*60;

    private static String signature = "signature";

    public String getToken(User user){
        Map<String,Object> claim = new HashMap<>();
        claim.put("username", user.getName());
        claim.put("id", user.getId());
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload
                .setClaims(claim)
                .setSubject("token")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return token;
    }

    public boolean checkToken(String token){
        if (token==null){
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
