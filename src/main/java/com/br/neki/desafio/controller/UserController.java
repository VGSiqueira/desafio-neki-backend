package com.br.neki.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.neki.desafio.Exception.UserException;
import com.br.neki.desafio.dto.user.UserInsertDTO;
import com.br.neki.desafio.dto.user.UserShowAllDTO;
import com.br.neki.desafio.dto.user.UserShowDTO;
import com.br.neki.desafio.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> insert (@RequestBody UserInsertDTO userInsertDTO) {
		try {
			UserShowDTO dto = userService.insert(userInsertDTO);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserShowAllDTO>> list() {
		List<UserShowAllDTO> users = userService.list();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> search(@PathVariable Long id) throws UserException {
		UserShowAllDTO user = userService.search(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
