package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.Ph;

@Repository
public interface PhRepository extends JpaRepository<Ph, Integer> {
	
	@Transactional(readOnly=true)	
	Ph findFirstByOrderByIdDesc();

}
