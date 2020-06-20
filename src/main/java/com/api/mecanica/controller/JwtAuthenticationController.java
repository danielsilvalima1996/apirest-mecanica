package com.api.mecanica.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.config.JwtTokenUtil;
import com.api.mecanica.model.JwtRequest;
import com.api.mecanica.model.Users;
import com.api.mecanica.repository.UsersRepository;
import com.api.mecanica.service.JwtUserDetailsService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("api/login")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UsersRepository repository;

	@ApiOperation(value = "Endpoint login")
	@PostMapping()
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		authentication(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getUsername());
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new JwtResponse(token));
		Users user = repository.findByEmail(authenticationRequest.getUsername());
		authentication(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		Map<Object, Object> model = new HashMap<>();
		model.put("token", token);
		model.put("email", authenticationRequest.getUsername());
		model.put("username", user.getUserName());
		model.put("avatar", user.getAvatar());

		return ResponseEntity.ok(model);
	}

	private void authentication(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
