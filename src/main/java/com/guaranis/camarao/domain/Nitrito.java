package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nitrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double nitrito;

	private Date horaMarcada;

	public Nitrito() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Nitrito(Integer id, double nitrito) {
		super();
		this.id = id;
		this.nitrito = nitrito;
		this.horaMarcada = new Date(System.currentTimeMillis());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNitrito() {
		return nitrito;
	}

	public void setNitrito(double nitrito) {
		this.nitrito = nitrito;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}

}
