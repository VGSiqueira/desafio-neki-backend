package com.br.neki.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.neki.desafio.Exception.SkillException;
import com.br.neki.desafio.Exception.UserException;
import com.br.neki.desafio.Exception.UserSkillException;
import com.br.neki.desafio.dto.userskill.UserSkillInsertDTO;
import com.br.neki.desafio.dto.userskill.UserSkillShowAllDTO;
import com.br.neki.desafio.dto.userskill.UserSkillShowDTO;
import com.br.neki.desafio.dto.userskill.UserSkillUpdateDTO;
import com.br.neki.desafio.service.UserSkillService;

@RestController
@RequestMapping("/user-skill")
public class UserSkillController {

	@Autowired
	UserSkillService userSkillService;
	
	@PostMapping
	public UserSkillShowDTO insert(@Valid @RequestBody UserSkillInsertDTO userSkillInsertDTO) throws UserException, SkillException {
		UserSkillShowDTO dto = userSkillService.insert(userSkillInsertDTO);
		return dto;
	}
	
	@GetMapping
	public ResponseEntity<List<UserSkillShowDTO>> list(){
		List<UserSkillShowDTO> userSkills = userSkillService.list();
		return new ResponseEntity<>(userSkills, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (!userSkillService.delete(id)) {
			return new ResponseEntity<>("User Skill não encontrada", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("User skill deletada com sucesso!", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserSkillUpdateDTO dto) throws UserSkillException {
		UserSkillShowAllDTO userSkillShowAllDTO = userSkillService.update(id, dto);
		if (userSkillShowAllDTO == null) {
			return new ResponseEntity<>("User Skill não encontrada", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userSkillShowAllDTO, HttpStatus.OK);
	}
}
