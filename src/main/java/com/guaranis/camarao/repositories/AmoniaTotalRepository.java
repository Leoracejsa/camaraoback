package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.AmoniaTotal;

@Repository
public interface AmoniaTotalRepository extends JpaRepository<AmoniaTotal, Integer> {
	
	@Transactional(readOnly=true)	
	AmoniaTotal findFirstByOrderByIdDesc();

}
