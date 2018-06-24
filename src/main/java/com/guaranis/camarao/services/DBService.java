package com.guaranis.camarao.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guaranis.camarao.domain.Cidade;
import com.guaranis.camarao.domain.Endereco;
import com.guaranis.camarao.domain.Estado;
import com.guaranis.camarao.domain.Usuario;
import com.guaranis.camarao.domain.enums.Perfil;
import com.guaranis.camarao.repositories.CidadeRepository;
import com.guaranis.camarao.repositories.EnderecoRepository;
import com.guaranis.camarao.repositories.EstadoRepository;
import com.guaranis.camarao.repositories.UsuarioRepository;


@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	@Autowired	
	private EnderecoRepository enderecoRepository;	
	
	public void instantiateTestDatabase() throws Exception {
		
		Estado est1 = new Estado(null, "Rio de Janeiro");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Ceará");

		Cidade c1 = new Cidade(null, "Belford Roxo", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Aldeota", est3);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.save(Arrays.asList(est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));

		Usuario us1 = new Usuario(null, "Leonardo Ahmed", "leonardo.ahmed@gmail.com", "31628382740", pe.encode("123"));
		Usuario us2 = new Usuario(null, "Gilson Almeida", "leonardo.ahmed@unigranrio.br", "31628382742", pe.encode("123"));
		us1.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		us2.getTelefones().addAll(Arrays.asList("938832321"));
		us1.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", us1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", us1, c2);
		Endereco e3 = new Endereco(null, "Rua dos Marujos", "104", "Apt 750", "Centro", "38777012", us2, c2);

		us1.getEnderecos().addAll(Arrays.asList(e1, e2));
		us2.getEnderecos().addAll(Arrays.asList(e3));

		usuarioRepository.save(Arrays.asList(us1,us2));
		enderecoRepository.save(Arrays.asList(e1, e2,e3));
		
		
		
}
}