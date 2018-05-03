package co.simplon.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.controller.dto.JwtDto;
import co.simplon.controller.dto.LoginDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@PostMapping
	public JwtDto login(@Validated @RequestBody LoginDto login) {
		
		// do authentication stuff here...
		
		final JwtDto jwt = new JwtDto();
		jwt.setToken("Teuuuuuuuub !!!!");
		return jwt;
	}
}
