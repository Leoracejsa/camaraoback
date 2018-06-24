package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.Nitrato;
import com.guaranis.camarao.services.NitratoService;

@RestController
@RequestMapping(value="/nitratos")
public class NitratoResource {
	
	@Autowired
	NitratoService nitratoService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Nitrato> find() throws Exception{		
		Nitrato nitrato = nitratoService.findNitrato();
		return ResponseEntity.ok().body(nitrato);
	}
}
