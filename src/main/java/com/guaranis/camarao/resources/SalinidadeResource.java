package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.Salinidade;
import com.guaranis.camarao.services.SalinidadeService;

@RestController
@RequestMapping(value="/salinidades")
public class SalinidadeResource {
	
	@Autowired
	SalinidadeService salinidadeService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Salinidade> find() throws Exception{		
		Salinidade salinidade = salinidadeService.findSalinidade();
		return ResponseEntity.ok().body(salinidade);
	}
}
