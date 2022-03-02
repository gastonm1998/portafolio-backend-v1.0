package com.apipotafilio.app.servicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.apipotafilio.app.entidades.Experiencia;

public interface ExperienciaService {

	
	public Iterable<Experiencia>findAll();
	
	public Page<Experiencia> findAll(Pageable pageable);
	
	public Optional<Experiencia> finfById(long id);
	
	public Experiencia save(Experiencia experiencia);
	
	public void deleteById(Long id);
}
