package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ph implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double ph;

	private Date horaMarcada;

	public Ph() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Ph(Integer id, double ph) {
		super();
		this.id = id;
		this.ph = ph;
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPh() {
		return ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}
}
