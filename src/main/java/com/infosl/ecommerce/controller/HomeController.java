package com.infosl.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.service.producto.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "usuario/home";
	}


	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		LOGGER.info("id producto {}", id);
		
		Producto producto= new Producto();
		Optional<Producto> optionalProducto = productoService.get(id);
		producto = optionalProducto.get();
		LOGGER.info("Objeto producto {}", producto);
		
		model.addAttribute("prodObtenido", producto);		
	
		return "usuario/productohome";
	}
}
