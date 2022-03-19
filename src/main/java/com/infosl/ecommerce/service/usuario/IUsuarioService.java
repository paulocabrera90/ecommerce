package com.infosl.ecommerce.service.usuario;

import java.util.List;
import java.util.Optional;

import com.infosl.ecommerce.model.Usuario;



public interface IUsuarioService {
	public Usuario save(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public void delete(Integer id);
	
	public List<Usuario> findAll();
	
	public  Optional<Usuario>  findByPrimaryKey(Integer id);
	
	public  Optional<Usuario> findByEmail(String email);
}
