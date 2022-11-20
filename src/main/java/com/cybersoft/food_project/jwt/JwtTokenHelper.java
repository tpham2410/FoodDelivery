package com.cybersoft.food_project.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenHelper {
    private  long expireTime = 8*60*60*1000;
    private final String  privateKey = "VG8gZW5jb2RlIGJpbmFyaWVzIChsaWtlIGltYWdlcywgZG9jdW1lbnRzLCBldGMuKSB1c2UgdGhlIGZpbGUgdXBsb2FkIGZvcm0gYSBsaXR0bGUgZnVydGhlciBkb3duIG9uIHRoaXMgcGFnZQ==" ;

    public String generateToken(String data){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + expireTime);

        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        String token = Jwts.builder()
                .setSubject(data)
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
}
