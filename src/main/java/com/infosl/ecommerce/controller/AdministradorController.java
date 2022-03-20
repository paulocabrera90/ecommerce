package com.infosl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.service.producto.IProductoService;
import com.infosl.ecommerce.service.usuario.IUsuarioService;
 
@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	private final Logger LOGGER = LoggerFactory.getLogger(AdministradorController.class);
	
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> listProductos = productoService.findAll();
		model.addAttribute("listaProductos" ,listProductos);
		
		return "administrador/home";
	}
	
	@GetMapping("/usuarios")
	public String findUsuarios(Model model) {
		
		List<Usuario> listUsuarios = usuarioService.findAll();
		model.addAttribute("listUsuarios" ,listUsuarios);
		LOGGER.info("Usuario registro {}", listUsuarios);
		
		return "administrador/usuarios";
	}
}
