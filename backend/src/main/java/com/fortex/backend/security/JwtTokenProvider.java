package com.fortex.backend.security;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fortex.backend.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;




@Component
public class JwtTokenProvider {

    /**
     * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
     * microservices environment, this key would be kept on a config-server.
     */
//    @Value("${security.jwt.token.secret-key:secret-key}")
//    private String secretKey;
//
//    @Value("${security.jwt.token.expire-length:3600000}")
//    private long validityInMilliseconds = 3600000; // 1h

@Autowired
private UserServiceImpl myAdminDetails;


public String createToken(String email, List<Role> roles) {

    Claims claims = Jwts.claims().setSubject(email);
    claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

    Date now = new Date();
    Date validity = new Date(now.getTime() + EXPIRATION_TIME);

    return Jwts.builder()//
            .setClaims(claims)//
            .setIssuedAt(now)//
            .setExpiration(validity)//
            .signWith(SignatureAlgorithm.HS256, SECRET)//
            .compact();
}

public Authentication getAuthentication(String token) {
    UserDetails adminDetails = myAdminDetails.loadUserByUsername(getUsername(token));
    return new UsernamePasswordAuthenticationToken(adminDetails, "", adminDetails.getAuthorities());
}

public String getUsername(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
}

public String resolveToken(HttpServletRequest req) {
    String bearerToken = req.getHeader(HEADER_STRING);
    if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
        return bearerToken.substring(7);
    }
    return null;
}

public boolean validateToken(String token) {
    try {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        return true;
    } catch (JwtException | IllegalArgumentException e) {
        throw new JwtException("Expired or invalid JWT token");
    }
}

}
