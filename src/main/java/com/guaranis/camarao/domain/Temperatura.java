package com.guaranis.camarao.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Temperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double temperatura;

	private Date horaMarcada;

	public Temperatura() {
		this.horaMarcada = new Date(System.currentTimeMillis());
	}

	public Temperatura(Integer id, double temperatura) {
		super();
		this.id = id;
		this.temperatura = temperatura;
		this.horaMarcada = new Date(System.currentTimeMillis());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public Date getHoraMarcada() {
		return horaMarcada;
	}

	public void setHoraMarcada(Date horaMarcada) {
		this.horaMarcada = horaMarcada;
	}
	
	@Override
	public String toString() {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();	
		builder.append(", Instante: ");
		builder.append(sdf.format(getHoraMarcada()));
		builder.append(", Temperatura registrada: ");
		builder.append(getTemperatura());		
		return builder.toString();
	}

}
