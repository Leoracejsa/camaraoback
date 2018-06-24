package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmoniaTotal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double amoniaTotal;

	private Date horaMarcada;

	public AmoniaTotal() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public AmoniaTotal(Integer id, double amoniaTotal) {
		super();
		this.id = id;
		this.amoniaTotal = amoniaTotal;
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmoniaTotal() {
		return amoniaTotal;
	}

	public void setAmoniaTotal(double amoniaTotal) {
		this.amoniaTotal = amoniaTotal;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}	
}
