package com.infosl.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usr_id;
	@Column
	private String  usr_name;
	private String usr_cod;
	private String usr_email;
	private String usr_direccion;
	private String usr_telefono;
	private String usr_tipo;
	private String usr_pass;
	
	@OneToMany(mappedBy = "user")
	private List<Producto> listProducto;
	
	@OneToMany(mappedBy = "user")
	private List<Orden> listOrden;
	
	public Usuario() {
		super();
	}	
	
	public Usuario(Integer usr_id, String usr_name, String usr_cod, String usr_email, String usr_direccion,
			String usr_telefono, String usr_tipo, String usr_pass) {
		super();
		this.usr_id = usr_id;
		this.usr_name = usr_name;
		this.usr_cod = usr_cod;
		this.usr_email = usr_email;
		this.usr_direccion = usr_direccion;
		this.usr_telefono = usr_telefono;
		this.usr_tipo = usr_tipo;
		this.usr_pass = usr_pass;
	}

	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_cod() {
		return usr_cod;
	}
	public void setUsr_cod(String usr_cod) {
		this.usr_cod = usr_cod;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_direccion() {
		return usr_direccion;
	}
	public void setUsr_direccion(String usr_direccion) {
		this.usr_direccion = usr_direccion;
	}
	public String getUsr_telefono() {
		return usr_telefono;
	}
	public void setUsr_telefono(String usr_telefono) {
		this.usr_telefono = usr_telefono;
	}
	public String getUsr_tipo() {
		return usr_tipo;
	}
	public void setUsr_tipo(String usr_tipo) {
		this.usr_tipo = usr_tipo;
	}
	public String getUsr_pass() {
		return usr_pass;
	}
	public void setUsr_pass(String usr_pass) {
		this.usr_pass = usr_pass;
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

	@Override
	public String toString() {
		return "Usuario [usr_id=" + usr_id + ", usr_name=" + usr_name + ", usr_cod=" + usr_cod + ", usr_email="
				+ usr_email + ", usr_direccion=" + usr_direccion + ", usr_telefono=" + usr_telefono + ", usr_tipo="
				+ usr_tipo + ", usr_pass=" + usr_pass + "]";
	}

	public List<Producto> getListProducto() {
		return listProducto;
	}

	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

	public List<Orden> getListOrden() {
		return listOrden;
	}

	public void setListOrden(List<Orden> listOrden) {
		this.listOrden = listOrden;
	}
	
	
	
		
}
