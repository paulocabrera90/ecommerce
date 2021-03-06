package com.infosl.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.swing.GroupLayout;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.service.UploadFileService;
import com.infosl.ecommerce.service.producto.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto,@RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		LOGGER.info("Objeto producto {}", producto);
		//Usuario
		Usuario usu = (Usuario) session.getAttribute("user");	
		
		producto.setUser(usu);
		
		//Imagen upload
		if (producto.getPro_id() == null) { // validacion cuando se crea un producto (id = null)
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}		
		productoService.save(producto);
		return "redirect:/productos";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto= new Producto();
		Optional<Producto> optionalProducto = productoService.get(id);
		producto = optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("prodObtenido", producto);
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		
		Producto prod = new Producto();
		prod = productoService.get(producto.getPro_id()).get();
		
		if(file.isEmpty()) {// obtenemos la imagen de la server			
			producto.setImagen(prod.getImagen());
		}else {      //Cuando se edita la imagen			
			if (!prod.getImagen().equals("default.jpg")) {
				upload.deleteImg(prod.getImagen());
			}
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		producto.setUser(prod.getUser());
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Integer id) {
		Producto prod = new Producto();
		prod = productoService.get(id).get();
		
		if (!prod.getImagen().equals("default.jpg")) {
			upload.deleteImg(prod.getImagen());
		}
		
		productoService.delete(id);
		return "redirect:/productos";
	}
	
}
