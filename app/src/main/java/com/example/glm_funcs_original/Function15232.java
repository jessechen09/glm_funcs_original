
package com.example.glm_funcs_original;

import java.security.Key;
import java.security.SignatureException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import io.jsonwebtoken.UnsupportedJwtException;

public class Function15232 {
      public static Claims parseClaims(String str) throws UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, ExpiredJwtException {
        final Claims[] claimsArr = new Claims[1];
        try {
            return Jwts.parserBuilder().setSigningKeyResolver(new SigningKeyResolverAdapter() { // from class: com.ionicframework.ionicapp410897.auth.JWTParser.1
                @Override // io.jsonwebtoken.SigningKeyResolverAdapter, io.jsonwebtoken.SigningKeyResolver
                public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
                    claimsArr[0] = claims;
                    return null;
                }
            }).build().parseClaimsJws(str).getBody();
        } catch (MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            if (claimsArr[0] == null) {
                throw e;
            }
            return claimsArr[0];
        }
    }
}