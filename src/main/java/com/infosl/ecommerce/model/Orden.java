package com.infosl.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Orden {
	@Id
	@GeneratedValue
	private Integer ord_id;
	
	@Column
	private String ord_numero;
	private Date ord_fecCrea;
	private Date ord_fecRec;
	
	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public Orden(Integer ord_id, String ord_numero, Date ord_fecCrea, Date ord_fecRec) {
		super();
		this.ord_id = ord_id;
		this.ord_numero = ord_numero;
		this.ord_fecCrea = ord_fecCrea;
		this.ord_fecRec = ord_fecRec;
	}

	public Integer getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(Integer ord_id) {
		this.ord_id = ord_id;
	}

	public String getOrd_numero() {
		return ord_numero;
	}

	public void setOrd_numero(String ord_numero) {
		this.ord_numero = ord_numero;
	}

	public Date getOrd_fecCrea() {
		return ord_fecCrea;
	}

	public void setOrd_fecCrea(Date ord_fecCrea) {
		this.ord_fecCrea = ord_fecCrea;
	}

	public Date getOrd_fecRec() {
		return ord_fecRec;
	}

	public void setOrd_fecRec(Date ord_fecRec) {
		this.ord_fecRec = ord_fecRec;
	}

	@Override
	public String toString() {
		return "Orden [ord_id=" + ord_id + ", ord_numero=" + ord_numero + ", ord_fecCrea=" + ord_fecCrea
				+ ", ord_fecRec=" + ord_fecRec + "]";
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

}
