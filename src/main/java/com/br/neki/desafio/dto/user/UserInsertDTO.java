package com.br.neki.desafio.dto.user;

import java.time.LocalDateTime;

import com.br.neki.desafio.model.User;

public class UserInsertDTO {

	private String login;
	private String password;
	private LocalDateTime lastLoginDate;
	
	public UserInsertDTO() {
	
	}

	public UserInsertDTO(User user) {
		super();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.lastLoginDate = user.getLastLoginDate();
	}
	
	public User toUser() {
		User user = new User();
		user.setLogin(this.login);
		user.setPassword(this.password);
		user.setLastLoginDate(this.lastLoginDate);
		
		return user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	
	
}
