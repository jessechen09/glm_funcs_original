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
        } catch (MalformedJwtException | UnsupportedJwtException | SignatureException | IllegalArgumentException e) {
            if (claimsArr[0] == null) {
                throw e;
            }
            return claimsArr[0];
        }
    }
}