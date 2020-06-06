package com.douglas.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.backend.domain.Categoria;
import com.douglas.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findOne(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(null);
	}
	
}
