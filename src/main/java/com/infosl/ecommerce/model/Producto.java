package com.infosl.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pro")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pro_id;
	
	@Column
	private String pro_nombre;
	private String pro_descr;
	private String imagen;
	private double pro_precio;
	private int pro_cant;
	
	@ManyToOne
	private Usuario user;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Producto(Integer pro_id, String pro_nombre, String pro_descr, String img, double pro_precio,
			int pro_cant, Usuario user) {
		super();
		this.pro_id = pro_id;
		this.pro_nombre = pro_nombre;
		this.pro_descr = pro_descr;
		this.imagen = img;
		this.pro_precio = pro_precio;
		this.pro_cant = pro_cant;
		this.user = user;
	}


	public Integer getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	public String getPro_descr() {
		return pro_descr;
	}

	public void setPro_descr(String pro_descr) {
		this.pro_descr = pro_descr;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String img) {
		this.imagen = img;
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) {
		this.pro_precio = pro_precio;
	}

	public int getPro_cant() {
		return pro_cant;
	}

	public void setPro_cant(int pro_cant) {
		this.pro_cant = pro_cant;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

	@Override
	public String toString() {
		return "Producto [pro_id=" + pro_id + ", pro_nombre=" + pro_nombre + ", pro_descr=" + pro_descr + ", imagen="
				+ imagen + ", pro_precio=" + pro_precio + ", pro_cant=" + pro_cant + ", user=" + user + "]";
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
	
}
