package com.br.neki.desafio.dto.userskill;

import com.br.neki.desafio.model.Skill;
import com.br.neki.desafio.model.UserSkill;

public class UserSkillShowAllDTO {

	private Long id;
	private Long knowledgeLevel;
	private Skill skill;
	
	public UserSkillShowAllDTO() {

	}

	public UserSkillShowAllDTO(UserSkill userSkill) {
		super();
		this.id = userSkill.getId();
		this.knowledgeLevel = userSkill.getKnowledgeLevel();
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

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
	
}
