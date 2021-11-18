package com.api.mecanica.service;

import java.util.ArrayList;

import com.api.mecanica.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByEmail(username);
//		if ("springuser".equals(username)) {
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado com o email: " + username);
		}
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}
