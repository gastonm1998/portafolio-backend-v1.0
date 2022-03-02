package com.apipotafilio.app.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apipotafilio.app.entidades.Experiencia;
import com.apipotafilio.app.repositorio.ExperienciaRepositorio;

@Service
public class ExperienciaServicioImpl implements ExperienciaService {
	
	@Autowired
	private ExperienciaRepositorio experienciaRepositorio ;
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Experiencia> findAll() {
		
		return experienciaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Experiencia> findAll(Pageable pageable) {
		
		return experienciaRepositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Experiencia> finfById(long id) {
		
		return experienciaRepositorio.findById(id);
	}

	@Override
	@Transactional
	public Experiencia save(Experiencia experiencia) {
		
		return experienciaRepositorio.save(experiencia);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		experienciaRepositorio.deleteById(id);
	}

}
