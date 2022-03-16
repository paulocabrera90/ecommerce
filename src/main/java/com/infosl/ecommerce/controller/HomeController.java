package com.infosl.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosl.ecommerce.service.producto.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "usuario/home";
	}
	
	
}
