package com.infosl.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.service.usuario.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	// /usuari/register
	@GetMapping("/registro")
	public String create() {
		
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario user) {
		LOGGER.info("Usuario registro {}", user);
		
		user.setUsr_tipo("USER");
		usuarioService.save(user);
		
		return "redirect:/";
	}

}
