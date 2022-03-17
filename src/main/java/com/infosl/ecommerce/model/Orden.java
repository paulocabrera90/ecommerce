package com.infosl.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ord")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ord_id;
	
	@Column
	private String ord_numero;
	private Date ord_fecCrea;
	private Date ord_fecRec;
	private double ord_total;
	
	@ManyToOne
	private Usuario user;
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalleOrd;
		

	public Orden() {
		super();
	}

	public Orden(Integer ord_id, String ord_numero, Date ord_fecCrea, Date ord_fecRec, Usuario user,
			DetalleOrden detalleOrd, double ord_total) {
		super();
		this.ord_id = ord_id;
		this.ord_numero = ord_numero;
		this.ord_fecCrea = ord_fecCrea;
		this.ord_fecRec = ord_fecRec;
		this.user = user;
		this.detalleOrd = detalleOrd;
		this.ord_total = ord_total;
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
				+ ", ord_fecRec=" + ord_fecRec + ", user=" + user + ", detalleOrd=" + detalleOrd + ", ord_total="
				+ ord_total + "]";
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

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public DetalleOrden getDetalleOrd() {
		return detalleOrd;
	}

	public void setDetalleOrd(DetalleOrden detalleOrd) {
		this.detalleOrd = detalleOrd;
	}

	public double getOrd_total() {
		return ord_total;
	}

	public void setOrd_total(double ord_total) {
		this.ord_total = ord_total;
	}
	
	
		
	
}
