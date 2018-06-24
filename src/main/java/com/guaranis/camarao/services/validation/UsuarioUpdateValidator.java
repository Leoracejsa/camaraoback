package com.guaranis.camarao.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.guaranis.camarao.domain.Usuario;
import com.guaranis.camarao.dto.UsuarioDTO;
import com.guaranis.camarao.repositories.UsuarioRepository;
import com.guaranis.camarao.resources.exception.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioDTO> {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UsuarioRepository repo;
	@Override
	public void initialize(UsuarioUpdate ann) {
	}

	@SuppressWarnings("unused")
	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String,String> map =(Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		
		
		Usuario aux = repo.findByEmail(objDto.getEmail());
		if(aux!=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email","email Já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}