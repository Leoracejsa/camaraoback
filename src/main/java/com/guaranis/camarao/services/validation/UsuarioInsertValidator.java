package com.guaranis.camarao.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.guaranis.camarao.domain.Usuario;
import com.guaranis.camarao.dto.UsuarioNewDTO;
import com.guaranis.camarao.repositories.UsuarioRepository;
import com.guaranis.camarao.resources.exception.FieldMessage;
import com.guaranis.camarao.services.validation.utils.BR;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {
	
	@Autowired
	private UsuarioRepository repo;
	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		if (!BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}		
		
		Usuario aux = repo.findByEmail(objDto.getEmail());
		if(aux!=null) {
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