package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	List<User> findByEmailLike(String email);
	
	List<User> findByEmailContainingIgnoreCase(String email);
	
	List<User> findByUserNameContainingIgnoreCase(String userName);
	
	List<User> findByActive(boolean active, Sort sort);

	List<User> findAll(Specification<User> or);
	
	long countByActive(Boolean active);
	
	long count();

}
