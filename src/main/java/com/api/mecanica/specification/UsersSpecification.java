package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.User;

public class UsersSpecification {

	public static Specification<User> codigoUsers(Long idUsers) {
		if(idUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idUsers);
	}
	
	public static Specification<User> emailUsers(String emailUsers) {
		if(emailUsers == null) {
			return null;
		}
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("email")), "%" + emailUsers + "%");
	}
	
	public static Specification<User> userNameUsers(String userNameUsers) {
		if(userNameUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("userName")), "%" + userNameUsers + "%");
	}
	
	public static Specification<User> activeUsers(Boolean activeUsers) {
		if(activeUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), activeUsers);
	}
}
