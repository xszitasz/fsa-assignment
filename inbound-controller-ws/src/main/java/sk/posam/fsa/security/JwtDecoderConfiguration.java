package sk.posam.fsa.security;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.text.ParseException;
import java.util.Map;

@Configuration
class JwtDecoderConfiguration {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri:}")
    private String issuerUri;

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-uri:}")
    private String jwkUri;

    @Bean
    @Profile("keycloak")
    JwtDecoder fromOidcIssuerLocation() {
        //klasicka validacia casu a vydavatela JWT
        OAuth2TokenValidator<Jwt> jwtValidator = JwtValidators.createDefaultWithIssuer(issuerUri);
        //kontrola podpisu
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkUri).build();
        jwtDecoder.setJwtValidator(jwtValidator);
        return jwtDecoder;
    }

    @Bean
    JwtDecoder jwtDecoder() throws ParseException {
        return token -> {
            try {
                JWT nimbusJwt = JWTParser.parse(token);
                String tokenValue = nimbusJwt.serialize();
                Map<String, Object> headers = nimbusJwt.getHeader().toJSONObject();
                Map<String, Object> claims = nimbusJwt.getJWTClaimsSet().getClaims();
                return new Jwt(tokenValue,
                        nimbusJwt.getJWTClaimsSet().getIssueTime().toInstant(),
                        nimbusJwt.getJWTClaimsSet().getExpirationTime().toInstant(),
                        headers,
                        claims);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
