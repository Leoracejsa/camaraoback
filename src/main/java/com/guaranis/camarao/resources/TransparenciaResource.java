package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.Transparencia;
import com.guaranis.camarao.services.TransparenciaService;

@RestController
@RequestMapping(value="/transparencias")
public class TransparenciaResource {
	
	@Autowired
	TransparenciaService transparenciaService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Transparencia> find() throws Exception{		
		Transparencia transparencia = transparenciaService.findTransparencia();
		return ResponseEntity.ok().body(transparencia);
	}
}
