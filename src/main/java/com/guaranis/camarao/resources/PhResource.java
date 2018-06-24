package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.Ph;
import com.guaranis.camarao.services.PhService;

@RestController
@RequestMapping(value="/phs")
public class PhResource {
	
	@Autowired
	PhService phService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Ph> find() throws Exception{		
		Ph ph = phService.findPh();
		return ResponseEntity.ok().body(ph);
	}
}
