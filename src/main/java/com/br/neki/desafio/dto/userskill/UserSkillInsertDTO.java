package com.br.neki.desafio.dto.userskill;

import com.br.neki.desafio.Exception.SkillException;
import com.br.neki.desafio.Exception.UserException;
import com.br.neki.desafio.model.Skill;
import com.br.neki.desafio.model.User;
import com.br.neki.desafio.model.UserSkill;
import com.br.neki.desafio.repository.SkillRepository;
import com.br.neki.desafio.repository.UserRepository;

public class UserSkillInsertDTO {

	private Long knowledgeLevel;
	private Long user;
	private Long skill;
	
	
	public UserSkill toUserSkill(UserRepository userRepository, SkillRepository skillRepository) throws UserException, SkillException {
		UserSkill userSkill = new UserSkill();
		
		userSkill.setKnowledgeLevel(this.knowledgeLevel);
		
		User u = userRepository.findById(this.user).orElseThrow(() -> new UserException("Usuário não cadastrado"));
		userSkill.setUser(u);
		
		Skill s = skillRepository.findById(this.skill).orElseThrow(() -> new SkillException("Skill não encontrada"));
		userSkill.setSkill(s);
		
		return userSkill;
	}
	
	public Long getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(Long knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public long getSkill() {
		return skill;
	}
	public void setSkill(long skill) {
		this.skill = skill;
	}

	public void setSkill(Long skill) {
		this.skill = skill;
	}
	
	
	
	
}
