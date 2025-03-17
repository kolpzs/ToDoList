package com.pin.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "your-256-bit-secret-key-here";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 dias

    public static String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role) // Adiciona o papel como uma claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String validateToken(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getSubject(); // Retorna o username
        } catch (Exception e) {
            return null; // Token inválido
        }
    }

    public static String extractRole(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("role", String.class); // Extrai o papel do token
    }
}
