//package tr.gov.ticaret.samplecookiename.common.security.util;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import io.micrometer.common.util.StringUtils;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseCookie;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.WebUtils;
//import tr.gov.ticaret.samplecookiename.common.security.model.CommonUserDetails;
//
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtUtilBean {
//    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(JwtUtilBean.class);
//
//    @Value("${app.jwtKey}")
//    private String jwtKey;
//
//    @Value("${app.jwtExpirationMilisecond}")
//    private int jwtExpirationMilisecond;
//
//    @Value("${app.jwtCookieName}")
//    private String jwtCookieName;
//
//    @Value("${keycloak.credentials.secret}")
//    private String keycloakCredentialSecret;
//
//    public String getJwtFromCookies(HttpServletRequest request) {
//        jwtCookieName = "samplecookiename";
//        Cookie cookie = WebUtils.getCookie(request, jwtCookieName);
//        if (cookie != null) {
//            return cookie.getValue();
//        } else {
//            return null;
//        }
//    }
//
//    public ResponseCookie generateJwtCookie(CommonUserDetails userPrincipal) {
////        jwtCookieName= "samplecookiename";
//        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
//        ResponseCookie cookie = ResponseCookie.from(jwtCookieName, jwt).path("/yrabp-api").maxAge(24 * 60 * 60).httpOnly(true).build();
//        return cookie;
//    }
//
//    public ResponseCookie getCleanJwtCookie() {
////        jwtCookieName= "samplecookiename";
//        ResponseCookie cookie = ResponseCookie.from(jwtCookieName, null).path("/yrabp-api").build();
//        return cookie;
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(key()).build()
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    private Key key() {
////        jwtSecretSaltKey = "======================TestJwtSecret=Spring===========================";
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtKey));
//    }
//
//    public String getJwtTokenInHeader(HttpServletRequest req) {
//        String bearerToken = req.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer "))
//            return bearerToken.substring(7);
//        return null;
//    }
//
//    public boolean validateJwtToken(String authToken) {
//        if (StringUtils.isEmpty(authToken)) {
//            logger.error("JWT degeri bos");
//            return false;
//        }
//        try {
//            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
//            return true;
//        } catch (MalformedJwtException e) {
//            logger.error("Hatali JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token in gecerlilik suresi doldu: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("Bu JWT token desteklenmiyor: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT degeri bos olabilir: {}", e.getMessage());
//        }
//        return false;
//    }
//
//    public String generateTokenFromUsername(String username) {
////        jwtExpirationMilisecond = 28800000;//8 saat
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMilisecond))
//                .signWith(key(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//}