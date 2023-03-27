package com.HrSystem.jwt;


import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author hrq
 * @date 2023/03/26
 *
 */
public class JwtTest {
    
    private long time = 1000l*60*60;

    private String signature = "admin";

    @Test
    public void jwtTest(){

        JwtBuilder jwtBuilder = Jwts.builder();
        Map<String,Object> claim = new HashMap<>();
        claim.put("username", "giao");
        claim.put("role", "admin");

        String token = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload
                .setClaims(claim)
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(token);
    }

    @Test
    public void parse(){
        String touken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi10ZXN0Iiwicm9sZSI6ImFkbWluIiwiZXhwIjoxNjc5ODE5MjA1LCJqdGkiOiJkN2U5ZTYwOS1hNzgzLTQwOWMtYjYxMC1lMDM1YmIwOGQ0YjMiLCJ1c2VybmFtZSI6ImdpYW8ifQ.Y10VeZ8YAlkYFboty2w5zmnY-4Nb_BcfFp_rmO6M3_g";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(touken);
        Claims body = claimsJws.getBody();
        System.out.println(body.get("username"));
        System.out.println(body.get("role"));
        System.out.println(body.getId());
        System.out.println(body.getExpiration());

    }
}
