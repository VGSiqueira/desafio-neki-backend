package com.br.neki.desafio.model;

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
@Table(name = "skill", schema = "teste_residencia")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "Campo de nome vazio")
	@Size(max = 100, message = "Nome acima de 100 caracteres")
	@Column(name = "name")
	private String name;
	
	@Column(name = "version")
	@Size(max = 10, message = "Versão com mais de 10 caracteres")
	private String version;
	
	@NotBlank(message = "Campo de descrição vazio")
	@Size(max = 255, message = "Descrição com mais de 255 caracteres")
	@Column(name = "description")
	private String description;
	
	@Size(max = 255, message = "Url acima de 255 caracteres")
	@Column(name = "image_url")
	private String imageUrl;

//	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<UserSkill> skills = new ArrayList<UserSkill>();

	public Skill(Long id,
			@NotBlank(message = "Campo de nome vazio") @Size(max = 100, message = "Nome acima de 100 caracteres") String name,
			@Size(max = 10, message = "Versão com mais de 10 caracteres") String version,
			@NotBlank(message = "Campo de descrição vazio") @Size(max = 255, message = "Descrição com mais de 255 caracteres") String description,
			@Size(max = 255, message = "Url acima de 255 caracteres") String imageUrl, List<UserSkill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
		this.skills = skills;
	}

	public Skill() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<UserSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkill> skills) {
		this.skills = skills;
	}
	
	
	
}
