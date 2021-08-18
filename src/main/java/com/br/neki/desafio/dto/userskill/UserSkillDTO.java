package com.br.neki.desafio.dto.userskill;

import com.br.neki.desafio.model.Skill;

public class UserSkillDTO {

	private Long knowledgeLevel;
	private Skill skill;
	

	public UserSkillDTO() {
	}

	public UserSkillDTO(Long knowledgeLevel, Skill skill) {
		super();
		this.knowledgeLevel = knowledgeLevel;
		this.skill = skill;
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
