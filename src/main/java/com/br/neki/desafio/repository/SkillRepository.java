package com.br.neki.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.neki.desafio.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
