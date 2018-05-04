package co.simplon.service;

import co.simplon.controller.dto.UserDto;
import co.simplon.security.JwtTokens;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.core.Authentication;

public interface JwtTokenService {

    JwtTokens createTokens(Authentication authentication);
    String createToken(UserDto user);
    String createRefreshToken(UserDto user);

    JwtTokens refreshJwtToken(String token);
    Jws<Claims> validateJwtToken(String token);

}