package idsa.progetto_idsa.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import idsa.progetto_idsa.service.impl.UserDetailsImpl;

@Component


public class JwtService {
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    private static final String SECRET_KEY = "EA882D845C8EA843AE79E5E9BA9C7";


    public String generateJwtToken(Authentication authentication){

        UserDetails userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts
                .builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt( new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean vaidateJwtToken(String authToken){
        try{
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parse(authToken);
            return true;
        }catch (MalformedJwtException e){
            logger.error("invalid jwt token: {}", e.getMessage());
        }catch (ExpiredJwtException e) {
            logger.error("expired jwt token: {}", e.getMessage());
        }catch (UnsupportedJwtException e) {
            logger.error("unsupported jwt token: {}", e.getMessage());
        }catch (IllegalArgumentException e) {
            logger.error("illegal jwt token: {}", e.getMessage());
        }

        return false;
    }

    public String getUsernameFromJwtToken(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();

        return username;
    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
