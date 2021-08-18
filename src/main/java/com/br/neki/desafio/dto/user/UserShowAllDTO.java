package com.br.neki.desafio.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.br.neki.desafio.dto.userskill.UserSkillShowAllDTO;
import com.br.neki.desafio.dto.userskill.UserSkillShowDTO;
import com.br.neki.desafio.model.User;
import com.br.neki.desafio.model.UserSkill;

public class UserShowAllDTO {

	private Long id;
	private String login;
	private List<UserSkillShowAllDTO> skills = new ArrayList<>();

	
	public UserShowAllDTO() {

	}
	
	public UserShowAllDTO(User user) {
		super();
		this.id = user.getId();
		this.login = user.getLogin();
		
		for (UserSkill u : user.getSkills()) {
			skills.add(new UserSkillShowAllDTO(u));
		}
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
	public List<UserSkillShowAllDTO> getSkills() {
		return skills;
	}
	public void setSkills(List<UserSkillShowAllDTO> skills) {
		this.skills = skills;
	}
	
	
}
