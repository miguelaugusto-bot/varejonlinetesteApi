package com.varejonline.varejonline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varejonline.varejonline.model.Itens;
import com.varejonline.varejonline.repository.ItensRepository;

@Service
public class ItensService {

	@Autowired
	private ItensRepository itensRepository;
	
	public ResponseEntity<List<Itens>> findAll(){
		List<Itens> listyItens =  itensRepository.findAll();
		if(listyItens.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(listyItens);
		}
	}
	
	public ResponseEntity<Itens> saveItens(Itens itens){
		return ResponseEntity.status(201).body(itensRepository.save(itens));
	}
	
	public Optional<Itens> putItens(Integer id, Itens itens){
		Optional<Itens> updateItens = itensRepository.findById(id);
		if(updateItens.isPresent()) {
			updateItens.get().setName_itens(itens.getName_itens());
			updateItens.get().setQtd_parts(itens.getQtd_parts());
			updateItens.get().setValue_uni(itens.getValue_uni());
			updateItens.get().setDisc_itens(itens.getDisc_itens());
			return Optional.ofNullable(itensRepository.save(updateItens.get()));
		}else {
			return (Optional.empty());
		}
	}
	
	public ResponseEntity<Itens> deleteItens(Integer id){
			if(itensRepository.existsById(id)) {
				itensRepository.deleteById(id);
			return ResponseEntity.status(200).build();
		}else {
			return  ResponseEntity.status(404).build();
		}
	}
}
