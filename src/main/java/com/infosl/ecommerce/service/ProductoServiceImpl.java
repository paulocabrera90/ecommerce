package com.infosl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosl.ecommerce.model.Producto;
import com.infosl.ecommerce.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
		return null;
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub		
		return Optional.ofNullable(productoRepository.getById(id));
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

}
