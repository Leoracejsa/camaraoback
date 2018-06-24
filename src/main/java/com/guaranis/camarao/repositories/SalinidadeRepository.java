package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.Salinidade;

@Repository
public interface SalinidadeRepository extends JpaRepository<Salinidade, Integer> {
	
	@Transactional(readOnly=true)	
	Salinidade findFirstByOrderByIdDesc();

}
