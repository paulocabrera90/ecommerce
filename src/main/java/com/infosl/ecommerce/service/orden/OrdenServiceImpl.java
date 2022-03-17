package com.infosl.ecommerce.service.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.repository.IOrdenRepository;

@Service
public class OrdenServiceImpl implements IOrdenService {
	
	@Autowired
	private IOrdenRepository iOrdenRepository;

	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return iOrdenRepository.save(orden);
	}

}
