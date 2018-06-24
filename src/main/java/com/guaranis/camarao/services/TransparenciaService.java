package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Transparencia;
import com.guaranis.camarao.repositories.TransparenciaRepository;

@Service
public class TransparenciaService {

	@Autowired
	TransparenciaRepository repo;

	public void generateTransparencia() {
		Transparencia transparencia = new Transparencia(null, (Math.random() * ((30 - 35) + 1) + 35));
		this.insert(transparencia);
	}

	public Transparencia insert(Transparencia obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Transparencia findTransparencia() {
		Transparencia transparencia = repo.findFirstByOrderByIdDesc();
		return transparencia;
	}

}
