package com.infosl.ecommerce.service.orden;

import java.util.List;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Usuario;

public interface IOrdenService {
	
	
	List<Orden> findAll();
	
	Orden save (Orden orden);
	
	String generarNroOrden();
	
	List<Orden> findByUser (Usuario usuario);
}
