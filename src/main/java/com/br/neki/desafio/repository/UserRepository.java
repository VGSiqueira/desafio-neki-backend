package com.br.neki.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.neki.desafio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByLogin(String login);

	
}
