package com.br.neki.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.neki.desafio.model.Skill;
import com.br.neki.desafio.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<Skill> list() {
		List<Skill> skills = skillRepository.findAll();
		
		return skills;
	}
}
