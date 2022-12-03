package com.cybersoft.food_project.jwt;

import com.google.gson.Gson;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenHelper {

    private final String  privateKey = "VG8gZW5jb2RlIGJpbmFyaWVzIChsaWtlIGltYWdlcywgZG9jdW1lbnRzLCBldGMuKSB1c2UgdGhlIGZpbGUgdXBsb2FkIGZvcm0gYSBsaXR0bGUgZnVydGhlciBkb3duIG9uIHRoaXMgcGFnZQ==" ;
    private Gson gson = new Gson();

    public String generateToken(String data, String type, long ExpireTime){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + ExpireTime);

        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        Map<String, Object> subJectData = new HashMap<>();

        subJectData.put("username", data);
        subJectData.put("type", type);

        String json = gson.toJson(subJectData);


        String token = Jwts.builder()
                .setSubject(json)
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }

    public String decodeToken(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        return Jwts.parserBuilder().setSigningKey(secretKey).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken (String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        boolean isSuccess = false;

        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build()
                    .parseClaimsJws(token);
            isSuccess = true;

        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return isSuccess;
    }

}
