package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.Nitrito;

@Repository
public interface NitritoRepository extends JpaRepository<Nitrito, Integer> {
	
	@Transactional(readOnly=true)	
	Nitrito findFirstByOrderByIdDesc();

}
