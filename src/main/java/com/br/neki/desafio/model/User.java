package com.br.neki.desafio.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user", schema = "teste_residencia")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "Campo de usuário vazio")
	@Size(max = 12, message = "Login acima de 122 cararcteres")
	@Column(name = "login")
	private String login;
	
	@NotBlank(message = "Campo SENHA vazia")
    @Size(max = 100, message = "Senha muito grande")
	private String password;
	
	@Column(name = "last_login_date")
	private LocalDateTime lastLoginDate;

//	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserSkill> skills = new ArrayList<UserSkill>();
	
	public User() {

	}

	public User(Long id,
			@NotBlank(message = "Campo de usuário vazio") @Size(max = 12, message = "Login acima de 122 cararcteres") String login,
			@NotBlank(message = "Campo SENHA vazia") @Size(max = 100, message = "Senha muito grande") String password,
			LocalDateTime lastLoginDate, List<UserSkill> skills) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
		this.skills = skills;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public List<UserSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkill> skills) {
		this.skills = skills;
	}


	
	
	
}
