package com.br.neki.desafio.dto.userskill;

import java.time.LocalDateTime;

import com.br.neki.desafio.Exception.UserSkillException;
import com.br.neki.desafio.model.UserSkill;
import com.br.neki.desafio.repository.UserSkillRepository;

public class UserSkillUpdateDTO {

	private Long knowledgeLevel;
	private LocalDateTime updatedAt = LocalDateTime.now();
	

	public UserSkill toUserSkillUpdate(Long id, UserSkillRepository userSkillRepository) throws UserSkillException {
		UserSkill userSkill = userSkillRepository.findById(id)
				.orElseThrow(() -> new UserSkillException("User skill não encontrada"));
		userSkill.setKnowledgeLevel(this.knowledgeLevel);
		userSkill.setUpdatedAt(this.updatedAt);
		return userSkill;
	}


	public Long getKnowledgeLevel() {
		return knowledgeLevel;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	
	
}
