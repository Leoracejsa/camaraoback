package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {

	@Transactional(readOnly=true)	
	Temperatura findFirstByOrderByIdDesc();
}
