package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Salinidade;
import com.guaranis.camarao.repositories.SalinidadeRepository;

@Service
public class SalinidadeService {

	@Autowired
	SalinidadeRepository repo;

	public void generateSalinidade() {
		Salinidade salinidade = new Salinidade(null, (Math.random() * ((20 - 25) + 1) + 25));
		this.insert(salinidade);
	}

	public Salinidade insert(Salinidade obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Salinidade findSalinidade() {
		Salinidade salinidade = repo.findFirstByOrderByIdDesc();
		return salinidade;
	}

}
