package com.guaranis.camarao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guaranis.camarao.domain.OxigenioDissolvido;
import com.guaranis.camarao.services.OxigenioDissolvidoService;

@RestController
@RequestMapping(value="/oxigenioDissolvidos")
public class OxigenioDissolvidoResource {
	
	@Autowired
	OxigenioDissolvidoService oxigenioDissolvidoService;	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<OxigenioDissolvido> find() throws Exception{		
		OxigenioDissolvido oxigenioDissolvido = oxigenioDissolvidoService.findOxigenioDissolvido();
		return ResponseEntity.ok().body(oxigenioDissolvido);
	}
}
