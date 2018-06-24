package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nitrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double nitrato;

	private Date horaMarcada;

	public Nitrato() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Nitrato(Integer id, double nitrato) {
		super();
		this.id = id;
		this.nitrato = nitrato;
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNitrato() {
		return nitrato;
	}

	public void setNitrato(double nitrato) {
		this.nitrato = nitrato;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}
}
