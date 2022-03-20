package com.infosl.ecommerce.service.orden;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Usuario;
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

	@Override
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return iOrdenRepository.findAll();
	}
	
	//000010 convertirlo a 
	@Override
	public String generarNroOrden() {
		int numero=0;
		String nroConcatenado= "";
		
		List<Orden> listOrden = findAll();
		List<Integer> listNumOrd = new ArrayList<Integer>();
		
		listOrden.stream().forEach(ord -> listNumOrd.add(Integer.parseInt(ord.getOrd_numero())));
		
		if (listOrden.isEmpty()) {
			numero = 1;
		}else {
			numero = listNumOrd.stream().max(Integer::compareTo).get();
			numero++;
		}
		
		nroConcatenado = cantDeDigitos(numero);// + String.valueOf(numero);	
		
		return nroConcatenado;
	}
	
	public String cantDeDigitos(int num){

        String numeroOrden=String.valueOf(num);        
        int numDigitos=numeroOrden.length(); //numero de digitos               
        
        for (int j=numDigitos; j<9; j++)//añadimos los ceros 
            numeroOrden="0"+numeroOrden;
        
        return numeroOrden;
    }

	@Override
	public List<Orden> findByUser(Usuario usuario) {
		// TODO Auto-generated method stub
		return iOrdenRepository.findByUser(usuario);
	}
	

}
