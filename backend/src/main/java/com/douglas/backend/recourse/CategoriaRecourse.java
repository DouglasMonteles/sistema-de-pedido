package com.douglas.backend.recourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.backend.domain.Categoria;
import com.douglas.backend.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecourse {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Categoria obj = service.findOne(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
