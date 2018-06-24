package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.Temperatura;
import com.guaranis.camarao.services.TemperaturaService;

@RestController
@RequestMapping(value="/temperaturas")
public class TemperaturaResource {
	
	@Autowired
	TemperaturaService temperaturaService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Temperatura> find() throws Exception{		
		Temperatura temperatura = temperaturaService.findTemperatura();
		return ResponseEntity.ok().body(temperatura);
	}
	
	@RequestMapping(value="/generateOut",method=RequestMethod.GET)
	public void generateTemperaturaAlertante() throws Exception{		
		temperaturaService.generateTemperaturaForaDoPadrao();
		
	}
}
