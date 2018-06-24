package com.guaranis.camarao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guaranis.camarao.domain.OxigenioDissolvido;

@Repository
public interface OxigenioDissolvidoRepository extends JpaRepository<OxigenioDissolvido, Integer> {
	
	@Transactional(readOnly=true)	
	OxigenioDissolvido findFirstByOrderByIdDesc();

}
