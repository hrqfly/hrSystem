package com.HrSystem.service;

import io.jsonwebtoken.*;
import com.HrSystem.entity.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static String superSignature = "signature";

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public String getToken(User user){
        logger.info(user.getId()+":getToken");
        Map<String,Object> claim = new HashMap<>();
        claim.put("username", user.getName());
        claim.put("id", user.getId());
        JwtBuilder jwtBuilder = Jwts.builder();
        return jwtBuilder
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
    }

    public String getSuperToken(User user){
        logger.info(user.getId()+":getSuperToken");
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
                .signWith(SignatureAlgorithm.HS256, superSignature)
                .compact();
        return token;
    }

    public boolean checkToken(String token){
        if (token==null){
            return false;
        }
        try {
            Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkSuperToken(String token){
        if (token==null){
            return false;
        }
        try {
            Jwts.parser().setSigningKey(superSignature).parseClaimsJws(token);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
