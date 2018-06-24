package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Nitrito;
import com.guaranis.camarao.repositories.NitritoRepository;

@Service
public class NitritoService {	
	
	@Autowired
	NitritoRepository repo;	
	
	public  void generateNitrito() {
		Nitrito nitrito =  new Nitrito(null,(Math.random() *((0.50 - 0.0 ) + 1) + 0.0));
		this.insert(nitrito);
		
	}
	
	public Nitrito insert(Nitrito obj) {
		obj.setId(null);
		obj = repo.save(obj);		
		return obj;
	}
	
	public Nitrito findNitrito() {		
		Nitrito nitrito = repo.findFirstByOrderByIdDesc();
		return nitrito;
	}
	
}
