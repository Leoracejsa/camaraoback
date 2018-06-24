package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.AmoniaTotal;
import com.guaranis.camarao.repositories.AmoniaTotalRepository;

@Service
public class AmoniaTotalService {

	@Autowired
	AmoniaTotalRepository repo;

	public void generateAmoniaTotal() {
		AmoniaTotal amoniaTotal = new AmoniaTotal(null, (Math.random() * ((0.2 - 0.10) + 1) + 0.10));
		this.insert(amoniaTotal);
	}

	public AmoniaTotal insert(AmoniaTotal obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public AmoniaTotal findAmoniaTotal() {
		AmoniaTotal amoniaTotal = repo.findFirstByOrderByIdDesc();
		return amoniaTotal;
	}

}
