package co.simplon.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication getAuthentication(Jws<Claims> request);
    Authentication authenticate(String username, String password);
}