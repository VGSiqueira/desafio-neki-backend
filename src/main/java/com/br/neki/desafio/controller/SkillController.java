package com.br.neki.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.neki.desafio.model.Skill;
import com.br.neki.desafio.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping
	public ResponseEntity<List<Skill>> list() {
		List<Skill> skills = skillService.list();
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}
	
}
