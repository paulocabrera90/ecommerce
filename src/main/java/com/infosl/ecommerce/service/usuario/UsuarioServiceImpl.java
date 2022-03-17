package com.infosl.ecommerce.service.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.save(usuario);
	}	

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		iUsuarioRepository.save(usuario);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		iUsuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findById(id);
	}

	
}
