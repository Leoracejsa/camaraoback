package com.guaranis.camarao.services;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.guaranis.camarao.domain.Temperatura;
import com.guaranis.camarao.domain.Usuario;

public abstract class AbstractEmailService implements EmailService {
	
	private String[] emails;
	
	private Integer contador = 0;
	
	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendOrderConfirmationEmail(Temperatura obj, List<Usuario> usuarios) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj, usuarios);
		sendEmail(sm);
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Temperatura obj, List<Usuario> usuarios) {			
		this.emails = new String[usuarios.size()];
		SimpleMailMessage sm = new SimpleMailMessage();		 
		usuarios.forEach(usuario -> {
		this.emails[this.contador] = usuario.getEmail();
		this.contador++;
			
		});
		this.contador = 0;
		sm.setTo(this.emails);
		sm.setFrom(sender);
		sm.setSubject("Alerta de medição: " + obj.getTemperatura());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	@Override
	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}

	protected String htmlFromTemplatePedido(Temperatura obj) {
		Context context = new Context();
		context.setVariable("temperatura", obj);
		return templateEngine.process("email/AlertaMonitoramento", context);
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Temperatura obj, List<Usuario> usuarios) {
		try {
			MimeMessage mm = prepareMimeMessageFromPedido(obj, usuarios);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendOrderConfirmationEmail(obj, usuarios);
		}
	}

	protected MimeMessage prepareMimeMessageFromPedido(Temperatura obj, List<Usuario> usuarios)
			throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);		
		usuarios.forEach(usuario -> {
			//this.usuariosEmail += usuario.getEmail() + ",";
		});
		mmh.setTo(this.emails);
		mmh.setFrom(sender);
		mmh.setSubject("Alerta de medição: " + obj.getTemperatura());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		return mimeMessage;
	}
}