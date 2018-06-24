package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salinidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double salinidade;

	private Date horaMarcada;

	public Salinidade() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Salinidade(Integer id, double salinidade) {
		super();
		this.id = id;
		this.salinidade = salinidade;
		this.horaMarcada = new Date(System.currentTimeMillis());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(double salinidade) {
		this.salinidade = salinidade;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}
}
