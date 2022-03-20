package com.infosl.ecommerce.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.infosl.ecommerce.model.Usuario;
import com.infosl.ecommerce.service.usuario.IUsuarioService;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	
	@Autowired
	private IUsuarioService iUsuarioService;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	@Autowired
	HttpSession httpSession;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Username {}", username);
		Optional<Usuario> optionalUser = iUsuarioService.findByEmail(username);
		if(optionalUser.isPresent()) {
			LOGGER.info("Es el id user {}", optionalUser.get().getUsr_id());
			httpSession.setAttribute("idUsuario", optionalUser.get().getUsr_id());
			Usuario user = optionalUser.get();
			
			return User.builder().username(user.getUsr_name()).password(user.getUsr_pass()).roles(user.getUsr_tipo()).build();
			//return User.builder().username(user.getUsr_name()).password(bCrypt.encode(user.getUsr_pass())).roles(user.getUsr_tipo()).build();
			
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

}
