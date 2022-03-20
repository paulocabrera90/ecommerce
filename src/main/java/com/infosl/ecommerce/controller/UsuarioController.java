package com.infosl.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.model.UsuarioTipo;
import com.infosl.ecommerce.service.orden.IOrdenService;
import com.infosl.ecommerce.service.usuario.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IOrdenService iOrdenService;
	
	// /usuari/register
	@GetMapping("/registro")
	public String create() {
		
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario user) {
		LOGGER.info("Usuario registro {}", user);
		
		user.setUsr_tipo(UsuarioTipo.USER.toString());
		usuarioService.save(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
	@PostMapping("/validate")
	public String validate(Usuario user, HttpSession session) {
		LOGGER.info("Usuario login a validate {}", user);		
		
		Optional<Usuario> usuario = usuarioService.findByEmail(user.getEmail());				
		//LOGGER.info("Usuario login validate {}", usuario.get());	
		
		if(usuario.isPresent()) {
			session.setAttribute("user", usuario.get());
			if(usuario.get().getUsr_tipo().equals(UsuarioTipo.ADMIN.toString())) {
				return "redirect:/administrador";
			}else {
				return "redirect:/";
			}
		} else {
			LOGGER.info("Usuario login a validar no EXISTE");	
		}
		return "redirect:/";
	}

	@GetMapping("/getCompras")
	public String getCompras(Model model, HttpSession session) {
		
		Usuario usuario = ((Usuario) session.getAttribute("user"));
		
		model.addAttribute("idSession", usuario);
		
		List<Orden> listOrden = iOrdenService.findByUser((Usuario) session.getAttribute("user"));
		
		model.addAttribute("listOrden", listOrden);
		return "usuario/compras"; 
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCompra(@PathVariable Integer id, Model model, HttpSession session) {
		
		Optional<Orden> orden = iOrdenService.findById(id);
		
		model.addAttribute("detallesList", orden.get().getListDetalle());
		
		//session
		Usuario usuario = ((Usuario) session.getAttribute("user"));		
		model.addAttribute("idSession", usuario);
		
		LOGGER.info("id de la orden {}", id);	
		
		return "usuario/detallecompra";
	}
	
	@GetMapping("/close")
	public String closeSession( HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
}
