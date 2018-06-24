package com.guaranis.camarao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Temperatura;
import com.guaranis.camarao.domain.Usuario;
import com.guaranis.camarao.repositories.TemperaturaRepository;


@Service
public class TemperaturaService {	
	
	@Autowired
	TemperaturaRepository repo;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UsuarioService usuarioService;
	
	public  void generateTemperatura() {
		Temperatura temperatura =  new Temperatura(null,(Math.random() *((33 - 28) + 1) + 28));
		this.insert(temperatura);
		
	}
	
	public Temperatura insert(Temperatura obj) {
		obj.setId(null);
		if(obj.getTemperatura()<=27 || obj.getTemperatura()>=34) {
			List<Usuario> usuarios = usuarioService.findAll();		
			emailService.sendOrderConfirmationEmail(obj,usuarios);
		}
		obj = repo.save(obj);		
		return obj;
	}
	
	public Temperatura findTemperatura() {		
		Temperatura temperatura = repo.findFirstByOrderByIdDesc();
		return temperatura;
	}
	
	public  void generateTemperaturaForaDoPadrao() {
		Temperatura temperatura =  new Temperatura(null,(Math.random() *((22 - 20) + 1) + 20));
		this.insert(temperatura);
		
	}
	

}
