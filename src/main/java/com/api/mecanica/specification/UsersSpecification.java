package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.Users;

public class UsersSpecification {

	public static Specification<Users> codigoUsers(Long idUsers) {
		if(idUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idUsers);
	}
	
	public static Specification<Users> emailUsers(String emailUsers) {
		if(emailUsers == null) {
			return null;
		}
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("email")), "%" + emailUsers + "%");
	}
	
	public static Specification<Users> userNameUsers(String userNameUsers) {
		if(userNameUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("userName")), "%" + userNameUsers + "%");
	}
	
	public static Specification<Users> activeUsers(Boolean activeUsers) {
		if(activeUsers == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), activeUsers);
	}
}
