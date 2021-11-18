package com.api.mecanica.config;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;

@Profile({ "dev", "prod" })
public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	Environment env;

	@Override
	public Optional<String> getCurrentAuditor() {
		final String[] envs = this.env.getActiveProfiles();
		String username = null;
		String jwtToken = null;
		if (envs[0].equals("test") || envs == null)
			username = "SYSTEM_TEST";
		else {
			final String requestTokenHeader = this.request.getHeader("Authorization");
			jwtToken = requestTokenHeader.substring(7);
			username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		}

		return Optional.of(username);
	}
}
