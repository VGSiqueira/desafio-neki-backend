package com.br.neki.desafio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.neki.desafio.Exception.UserException;
import com.br.neki.desafio.dto.user.UserInsertDTO;
import com.br.neki.desafio.dto.user.UserShowAllDTO;
import com.br.neki.desafio.dto.user.UserShowDTO;
import com.br.neki.desafio.model.User;
import com.br.neki.desafio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserShowDTO insert(UserInsertDTO userInsertDTO) throws UserException {
		
		User user = userRepository.findByLogin(userInsertDTO.getLogin());
		
		if (user != null) {
			throw new UserException("Usuário já existente, insira outro.");
		}
		
		User newUser = new User();
		newUser.setLogin(userInsertDTO.getLogin());
		newUser.setPassword(userInsertDTO.getPassword());
		newUser.setLastLoginDate(LocalDateTime.now());
		
		newUser = userRepository.save(newUser);
		
		return new UserShowDTO(newUser);
		
	}
	
	public List<UserShowAllDTO> list() {
		List<UserShowAllDTO> dtos = new ArrayList<>();
		List<User> users = userRepository.findAll();
		
		for (User user : users) {
			UserShowAllDTO dto = new UserShowAllDTO(user);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public UserShowAllDTO search(Long id) throws UserException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserException("Usuário não encontrado"));
		
		return new UserShowAllDTO(user);
	}
}
