package com.infosl.ecommerce.service.orden;

import java.util.List;

import com.infosl.ecommerce.model.Orden;

public interface IOrdenService {
	
	
	List<Orden> findAll();
	
	Orden save (Orden orden);
	
	String generarNroOrden();
}
