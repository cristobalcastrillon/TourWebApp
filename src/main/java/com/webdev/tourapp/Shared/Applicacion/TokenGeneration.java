package com.webdev.tourapp.Shared.Applicacion;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



public class TokenGeneration {
    private final String PREFIX = "Bearer ";
    private final String SECRET = "vewysecwet_key";
    private final String CLAIM = "authorities";
    private final String ID = "TourApp";
    private final int validity = 1000000000;
    public TokenGeneration() {
    }

    public TokenGenerationResponse execute(String username) {
        List<GrantedAuthority> grantedAuthories = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_GUIDE");
        String token = Jwts.builder()
                .setId(ID)
                .setSubject(username)
                .claim(CLAIM, grantedAuthories.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        return new TokenGenerationResponse(PREFIX + token);
    }

}
