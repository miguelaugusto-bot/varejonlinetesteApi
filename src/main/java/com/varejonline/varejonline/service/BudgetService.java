package com.varejonline.varejonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varejonline.varejonline.model.Budget;
import com.varejonline.varejonline.repository.BudgetRepository;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;
	
	public ResponseEntity<List<Budget>> findAll(){
		List<Budget> listBudget = budgetRepository.findAll();
		if(listBudget.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(listBudget);
		}
	}
	
	public ResponseEntity<Budget> findById(Integer id){
		return budgetRepository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}
	
	public ResponseEntity<Budget> saveBudget(Budget budget){
		return ResponseEntity.status(200).body(budgetRepository.save(budget));
	}
	
	public ResponseEntity<Budget> putBudget(Budget budget){
		return ResponseEntity.status(200).body(budgetRepository.save(budget));
	}
	
	
	public ResponseEntity<Budget> deleteBudget(Integer id){
			if(budgetRepository.existsById(id)) {
			budgetRepository.deleteById(id);
			return ResponseEntity.status(200).build();
		}else {
			return  ResponseEntity.status(404).build();
		}
	}
	
}
