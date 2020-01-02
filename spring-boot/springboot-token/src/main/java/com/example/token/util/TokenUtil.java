package com.example.token.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.token.common.Common;
import com.example.token.user.entity.UserInfo;
import org.apache.catalina.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token 生成等相关方法
 */
public class TokenUtil {

    /**
     * 签名生成方法
     *
     * @param userName
     * @param userID
     * @return 加密的token
     */
    public static String sign(String userName, String userID) {
        Date expireTime = new Date(System.currentTimeMillis() + Common.EXPIRE_TIME);

        Algorithm algorithm = Algorithm.HMAC256(Common.TOKEN_SECRET);

        Map<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        return JWT.create()
                .withHeader(header)
                .withClaim("loginName", userName)
                .withClaim("userID", userID)
                .withExpiresAt(expireTime)
                .sign(algorithm);
    }

    public static <T> T decode(String token, Class<T> tClass) {
        Algorithm algorithm = Algorithm.HMAC256(Common.TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            System.out.println("########### token expired ##########");
            return null ;
        }

        return (T) decodedJWT;
    }

    public static void main(String[] args) {
        String token = sign("Lee", "123456");
        DecodedJWT decodedJWT = null;
        try {
            Thread.sleep(2000);
            decodedJWT = (DecodedJWT) decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dpbk5hbWUiOiJMZWUiLCJleHAiOjE1Nzc3NjAwNjEsInVzZXJJRCI6IjEyMzQ1NiJ9.9kaXUHZEPub4_1ls8dkRnrFXaF09Akn_tkXO1gr_u90", Object.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("########### token expired ##########");

        }

        if (decodedJWT != null) {
            String decodeToken = decodedJWT.getToken();
            System.out.println(decodeToken);

            String userID = decodedJWT.getClaim("userID").asString();
            System.out.println(userID);
        }

    }

}
