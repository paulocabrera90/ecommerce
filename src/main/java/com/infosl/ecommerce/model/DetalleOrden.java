package com.infosl.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DetalleOrden {
	
	@Id
	@GeneratedValue
	private Integer ordd_id;
	
	@Column
	private String ordd_nombre;
	private double ordd_precio;
	private double ordd_total;
	private double ordd_cant;
	
	public DetalleOrden() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public Integer getOrdd_id() {
		return ordd_id;
	}

	public void setOrdd_id(Integer ordd_id) {
		this.ordd_id = ordd_id;
	}

	public String getOrdd_nombre() {
		return ordd_nombre;
	}

	public void setOrdd_nombre(String ordd_nombre) {
		this.ordd_nombre = ordd_nombre;
	}

	public double getOrdd_precio() {
		return ordd_precio;
	}

	public void setOrdd_precio(double ordd_precio) {
		this.ordd_precio = ordd_precio;
	}

	public double getOrdd_total() {
		return ordd_total;
	}

	public void setOrdd_total(double ordd_total) {
		this.ordd_total = ordd_total;
	}

	public double getOrdd_cant() {
		return ordd_cant;
	}

	public void setOrdd_cant(double ordd_cant) {
		this.ordd_cant = ordd_cant;
	}

	@Override
	public String toString() {
		return "DetalleOrden [ordd_id=" + ordd_id + ", ordd_nombre=" + ordd_nombre + ", ordd_precio=" + ordd_precio
				+ ", ordd_total=" + ordd_total + ", ordd_cant=" + ordd_cant + "]";
	}
	
	
}
