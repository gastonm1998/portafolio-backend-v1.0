package com.apipotafilio.app.entidades;

import java.io.Serializable;
//import java.util.Date;// cambiar por sql si no funciona


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "experiencias")
public class Experiencia implements Serializable{
	
	
	private static final long serialVersionUID = -2130760578279892703L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length = 50)
	private String nombreEmpresa;
	
	//prueba fechas
	
	private String fechaInicio;
	


	//pruba de aderir a sql
	
    
	private String FechaFin;
	


	@Column(length = 7)
	private String color;
	
	private String descripcion;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	
	
	//fechas

}
