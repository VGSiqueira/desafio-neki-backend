package com.br.neki.desafio.dto.user;

import java.time.LocalDateTime;

import com.br.neki.desafio.model.User;

public class UserShowDTO {

	private Long id;
	private String login;
	private LocalDateTime lastLoginDate;
	
	public UserShowDTO() {
	
	}

	public UserShowDTO(User user) {
		
		super();
		this.id = user.getId();
		this.login = user.getLogin();
		this.lastLoginDate = user.getLastLoginDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	
}
