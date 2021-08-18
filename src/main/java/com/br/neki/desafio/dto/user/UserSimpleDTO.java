package com.br.neki.desafio.dto.user;

import com.br.neki.desafio.model.User;

public class UserSimpleDTO {

	private Long id;
	
	public UserSimpleDTO () {
		
	}
	
	public UserSimpleDTO(Long id) {
		super();
		this.id = id;
	}

	public User toUser() {
		User user = new User();
		user.setId(this.id);
		return user;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
