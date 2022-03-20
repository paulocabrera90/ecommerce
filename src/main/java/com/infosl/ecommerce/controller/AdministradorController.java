package com.infosl.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.service.detalleorden.IDetalleOrdenService;
import com.infosl.ecommerce.service.orden.IOrdenService;
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
	@Autowired
	private IOrdenService iOrdenService;
	@Autowired
	private IDetalleOrdenService iDetalleOrdenService;
	
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
	
	@GetMapping("/ordenes")
	public String findOrdenes(Model model) {
		
//		List<Usuario> listUsuarios = usuarioService.findAll();
		model.addAttribute("listOrdenes" ,iOrdenService.findAll());
//		LOGGER.info("Usuario registro {}", listUsuarios);
		
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleOrden(@PathVariable Integer id, Model model) {
		
		Optional<Orden> orden = iOrdenService.findById(id);
		
		model.addAttribute("detallesList", orden.get().getListDetalle());		
		
		LOGGER.info("id de la orden {}", id);	
		
		return "administrador/detalleorden";
	}
}
