package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OxigenioDissolvido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double oxigenioDissolvido;

	private Date horaMarcada;

	public OxigenioDissolvido() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public OxigenioDissolvido(Integer id, double oxigenioDissolvido) {
		super();
		this.id = id;
		this.oxigenioDissolvido = oxigenioDissolvido;
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getOxigenioDissolvido() {
		return oxigenioDissolvido;
	}

	public void setOxigenioDissolvido(double oxigenioDissolvido) {
		this.oxigenioDissolvido = oxigenioDissolvido;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}
}
