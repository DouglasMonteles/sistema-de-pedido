package com.douglas.backend.recourse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.backend.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecourse {

	@GetMapping
	public List<Categoria> findAll() {
		Categoria c1 = new Categoria(1, "Informática");
		Categoria c2 = new Categoria(2, "Cama, mesa e banho");
		
		List<Categoria> list = new ArrayList<Categoria>();
		list.add(c1);
		list.add(c2);
		
		return list;
	}
	
}
