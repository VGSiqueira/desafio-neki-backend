package com.br.neki.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.neki.desafio.Exception.SkillException;
import com.br.neki.desafio.Exception.UserException;
import com.br.neki.desafio.Exception.UserSkillException;
import com.br.neki.desafio.dto.userskill.UserSkillInsertDTO;
import com.br.neki.desafio.dto.userskill.UserSkillShowAllDTO;
import com.br.neki.desafio.dto.userskill.UserSkillShowDTO;
import com.br.neki.desafio.dto.userskill.UserSkillUpdateDTO;
import com.br.neki.desafio.model.UserSkill;
import com.br.neki.desafio.repository.SkillRepository;
import com.br.neki.desafio.repository.UserRepository;
import com.br.neki.desafio.repository.UserSkillRepository;

@Service
public class UserSkillService {

	@Autowired
	private UserSkillRepository userSkillRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserSkillShowDTO insert(UserSkillInsertDTO dto) throws UserException, SkillException {
		UserSkill userSkill = dto.toUserSkill(userRepository, skillRepository);
		userSkillRepository.save(userSkill);
		return new UserSkillShowDTO(userSkill);
	}
	
	public List<UserSkillShowDTO> list() {
		List<UserSkillShowDTO> dtos = new ArrayList<>();
		List<UserSkill> userSkills = userSkillRepository.findAll();
		
		for (UserSkill userSkill : userSkills) {
			UserSkillShowDTO dto = new UserSkillShowDTO(userSkill);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public boolean delete(Long id) {
		if (!userSkillRepository.existsById(id)) {
			return false;
		}
		userSkillRepository.deleteById(id);
		return true;
	}
	
	public UserSkillShowAllDTO update(Long id, UserSkillUpdateDTO dto) throws UserSkillException {
		if (!userSkillRepository.existsById(id)) {
			return null;
		}
		UserSkill userSkill = dto.toUserSkillUpdate(id, userSkillRepository);
		userSkillRepository.save(userSkill);
		return new UserSkillShowAllDTO(userSkill);
	}
}
