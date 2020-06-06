package com.douglas.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public List<Categoria> findAll() {
		List<Categoria> list = repository.findAll();
		return list;
	}
	
	public Categoria insert(Categoria obj) {
		obj = repository.save(obj);
		return obj;
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = findOne(obj.getId());
		updateData(obj, newObj);
		return repository.save(newObj);
	}
	
	public void updateData(Categoria obj, Categoria newObj) {
		newObj.setNome(obj.getNome());
	}
	
	public void delete(Integer id) {
		findOne(id);
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Nao é posível excluir uma categoria que possui produtos vinculados a ela.");
		}
	}
	
}
