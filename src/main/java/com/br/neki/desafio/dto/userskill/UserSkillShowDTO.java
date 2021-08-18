package com.br.neki.desafio.dto.userskill;

import com.br.neki.desafio.model.Skill;
import com.br.neki.desafio.model.User;
import com.br.neki.desafio.model.UserSkill;

public class UserSkillShowDTO {

	private Long id;
	private Long knowledgeLevel;
	private User user;
	private Skill skill;
	
	public UserSkillShowDTO() {
		
	}
	
	public UserSkillShowDTO(UserSkill userSkill) {
		super();
		this.id = userSkill.getId();
		this.knowledgeLevel = userSkill.getKnowledgeLevel();
		this.user = userSkill.getUser();
		this.skill = userSkill.getSkill();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKnowledgeLevel() {
		return knowledgeLevel;
	}

	public void setKnowledgeLevel(Long knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
}
