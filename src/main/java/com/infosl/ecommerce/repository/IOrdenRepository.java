package com.infosl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosl.ecommerce.model.Orden;
import com.infosl.ecommerce.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{

	List<Orden> findByUser (Usuario usuario);
}
