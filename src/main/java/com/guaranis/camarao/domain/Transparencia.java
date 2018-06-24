package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transparencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double transparencia;

	private Date horaMarcada;

	public Transparencia() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Transparencia(Integer id, double transparencia) {
		super();
		this.id = id;
		this.transparencia = transparencia;
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTransparencia() {
		return transparencia;
	}

	public void setTransparencia(double transparencia) {
		this.transparencia = transparencia;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}	
}
