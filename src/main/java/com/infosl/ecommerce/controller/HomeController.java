package com.infosl.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infosl.ecommerce.model.DetalleOrden;
import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.service.producto.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductoService productoService;
	
	//Almacenar los detalles de orden
	List<DetalleOrden> detalleOrdensList = new ArrayList<DetalleOrden>();
	//Datos de la orden
	Orden orden = new Orden();
	
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
	
	@PostMapping("/carrito")
	public String addCarrito(@RequestParam Integer pro_id, @RequestParam Integer cantidad, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto= new Producto();
		double sumaTotal= 0;
		
		Optional<Producto> optionalProducto = productoService.get(pro_id);
		producto = optionalProducto.get();
		LOGGER.info("Objeto producto al carrito {}", producto);
		LOGGER.info("Cantidad: {}", cantidad);
		
		//Se carga el detalle de la orden
		detalleOrden.setOrdd_cant(cantidad);
		detalleOrden.setOrdd_precio(producto.getPro_precio());
		detalleOrden.setOrdd_nombre(producto.getPro_nombre());
		detalleOrden.setOrdd_total(producto.getPro_precio()*cantidad);
		detalleOrden.setProd(producto);
		
		detalleOrdensList.add(detalleOrden);
		
		// usando funcion lamda, convierto y sumo
		sumaTotal = detalleOrdensList.stream().mapToDouble(dt->dt.getOrdd_total()).sum();
		
		orden.setOrd_total(sumaTotal);
		
		LOGGER.info("Lista detalle orden: {}", detalleOrdensList);
		model.addAttribute("listDetalleOrden", detalleOrdensList);
		model.addAttribute("orden", orden);
		
		return "usuario/carrito";
	}
	
	//Quitar un producto del Carrito
	@GetMapping("/delete/carrito/{id}")
	public String deleteProdCar(@PathVariable Integer id, Model model) {
		
		//Detalle de nuevos productos
		List<DetalleOrden> listDetalleOrdNueva = new ArrayList<DetalleOrden>();
		
		for (DetalleOrden detalleOrden : detalleOrdensList) {
			if(detalleOrden.getProd().getPro_id() != id) {
				listDetalleOrdNueva.add(detalleOrden);
			}
		}
		detalleOrdensList = listDetalleOrdNueva;
		
		double sumaTotal= 0;
		// usando funcion lamda, convierto y sumo
		sumaTotal = detalleOrdensList.stream().mapToDouble(dt->dt.getOrdd_total()).sum();				
		orden.setOrd_total(sumaTotal);
		
		LOGGER.info("Lista detalle orden Nueva: {}", detalleOrdensList);
		model.addAttribute("listDetalleOrden", detalleOrdensList);
		model.addAttribute("orden", orden);
		
		return "usuario/carrito";
	}
}
