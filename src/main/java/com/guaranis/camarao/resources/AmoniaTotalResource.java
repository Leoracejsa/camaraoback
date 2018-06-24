package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.AmoniaTotal;
import com.guaranis.camarao.services.AmoniaTotalService;

@RestController
@RequestMapping(value="/amonias")
public class AmoniaTotalResource {
	
	@Autowired
	AmoniaTotalService amoniaTotalService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<AmoniaTotal> find() throws Exception{		
		AmoniaTotal amoniaTotal = amoniaTotalService.findAmoniaTotal();
		return ResponseEntity.ok().body(amoniaTotal);
	}
}
