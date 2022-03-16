package com.infosl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.service.producto.ProductoService;
 
@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> listProductos = productoService.findAll();
		model.addAttribute("listaProductos" ,listProductos);
		
		return "administrador/home";
	}
}
