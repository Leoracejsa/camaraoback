package com.guaranis.camarao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.OxigenioDissolvido;
import com.guaranis.camarao.repositories.OxigenioDissolvidoRepository;

@Service
public class OxigenioDissolvidoService {	
	
	@Autowired
	OxigenioDissolvidoRepository repo;	
	
	public  void generateOxigenioDissolvido() {
		OxigenioDissolvido oxigenioDissolvido =  new OxigenioDissolvido(null,(Math.random() *((10 - 5.50) + 1) + 5.50));
		this.insert(oxigenioDissolvido);
		
	}
	
	public OxigenioDissolvido insert(OxigenioDissolvido obj) {
		obj.setId(null);
		obj = repo.save(obj);		
		return obj;
	}
	
	public OxigenioDissolvido findOxigenioDissolvido() {		
		OxigenioDissolvido oxigenioDissolvido = repo.findFirstByOrderByIdDesc();
		return oxigenioDissolvido;
	}
	
}
