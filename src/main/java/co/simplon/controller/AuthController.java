package co.simplon.controller;

import bzh.tibus29.spring.metrik.Metrik;
import bzh.tibus29.spring.metrik.TraceMode;
import co.simplon.security.JwtTokens;
import co.simplon.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.simplon.controller.dto.JwtDto;
import co.simplon.controller.dto.LoginDto;

import javax.inject.Inject;
import java.io.ObjectOutputStream;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
@Metrik(traceMode = TraceMode.AUTO) // https://github.com/tibus29/spring-metrik
public class AuthController {

	@GetMapping("/me")
	public Principal user(Principal principal) {
		return principal;
	}

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenService jwtTokenService;

	@PostMapping
	public ResponseEntity authenticate(@RequestBody LoginDto authenticationRequest) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if(authentication != null && authentication.isAuthenticated()) {
			JwtTokens tokens = jwtTokenService.createTokens(authentication);
			return ResponseEntity.ok().body(tokens);
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED.getReasonPhrase());
	}

	/*@PostMapping(value = "/auth/refresh", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity refreshToken(@RequestBody RefreshRequest refreshRequest) {
		try {
			JwtTokens tokens = jwtTokenService.refreshJwtToken(refreshRequest.refreshToken);
			return ResponseEntity.ok().body(tokens);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		}
	}*/
}
