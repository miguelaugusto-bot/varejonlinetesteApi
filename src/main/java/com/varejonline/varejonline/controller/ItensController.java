package com.varejonline.varejonline.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varejonline.varejonline.model.Itens;
import com.varejonline.varejonline.service.ItensService;

@RestController
@RequestMapping("/itens")
public class ItensController {

	@Autowired
	private ItensService itensService;
	
	@GetMapping
	public ResponseEntity<List<Itens>> getAll(){
		return itensService.findAll();
	}
	
	@PostMapping("/insert-itens")
	public ResponseEntity<Itens> postItens(@Valid @RequestBody Itens itens){
		return itensService.saveItens(itens);
	}
	
	@PutMapping(path = "/put-itens/{id}")
	public Optional<Itens> putItens(@Valid @PathVariable Integer id, @RequestBody Itens itens){
		return itensService.putItens(id, itens);
	}
	
	@DeleteMapping(path = "/delete-itens/id/{id}")
	public ResponseEntity<Itens> deleteItens(@Valid @PathVariable Integer id){
		return itensService.deleteItens(id);
	}
}
