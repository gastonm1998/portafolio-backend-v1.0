package com.apipotafilio.app.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apipotafilio.app.entidades.Experiencia;
import com.apipotafilio.app.servicio.ExperienciaService;

@RestController
@RequestMapping("/api/experiencias")

public class ExperienciaControlador {

	
	@Autowired
	private ExperienciaService experienciaService;
	
	//crear usuario
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<?> create ( @RequestBody Experiencia experiencia){
		return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.save(experiencia));
	}
	
	//encontrar por id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long Experienciaid){
		
		Optional<Experiencia> oExperiencia = experienciaService.finfById(Experienciaid);
		
		if(!oExperiencia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oExperiencia);
	}
	
	//actualizar
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Experiencia experienciaDetalis, @PathVariable(value = "id") long experienciaID ){
		
		Optional<Experiencia> experiencia = experienciaService.finfById(experienciaID);
		if(!experiencia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		experiencia.get().setColor(experienciaDetalis.getColor());
		experiencia.get().setDescripcion(experienciaDetalis.getDescripcion());
		experiencia.get().setFechaInicio(experienciaDetalis.getFechaInicio());
		experiencia.get().setFechaFin(experienciaDetalis.getFechaFin());
		experiencia.get().setNombreEmpresa(experienciaDetalis.getNombreEmpresa());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.save(experiencia.get()));
		
		
	}
	
	//eliminar
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long Experienciaid){
		if(!experienciaService.finfById(Experienciaid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		experienciaService.deleteById(Experienciaid);
		return ResponseEntity.ok().build();
	}
	
	//devolver todo
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Experiencia> readAll(){
		List<Experiencia> experiencia = StreamSupport
				.stream(experienciaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return experiencia;
	}
	
}
