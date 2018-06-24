package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Nitrato;
import com.guaranis.camarao.repositories.NitratoRepository;

@Service
public class NitratoService {	
	
	@Autowired
	NitratoRepository repo;	
	
	public  void generateNitrato() {
		Nitrato nitrato =  new Nitrato(null,(Math.random() *((5.0 - 0.0) + 1) + 0.0));
		this.insert(nitrato);
		
	}
	
	public Nitrato insert(Nitrato obj) {
		obj.setId(null);
		obj = repo.save(obj);		
		return obj;
	}
	
	public Nitrato findNitrato() {		
		Nitrato nitrato = repo.findFirstByOrderByIdDesc();
		return nitrato;
	}
	
}
