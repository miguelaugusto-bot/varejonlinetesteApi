package com.varejonline.varejonline.controller;

import java.util.List;

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

import com.varejonline.varejonline.model.Budget;
import com.varejonline.varejonline.service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;
	
	@GetMapping
	public ResponseEntity<List<Budget>> getAll(){
		return budgetService.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Budget> getById(@PathVariable Integer id){
		return budgetService.findById(id);
	}
	
	@PostMapping("/insert-budget")
	public ResponseEntity<Budget> postBudget(@Valid @RequestBody Budget budget){
		return budgetService.saveBudget(budget);
	}
	
	@PutMapping("/put-budget")
	public ResponseEntity<Budget> putBudget(@Valid @RequestBody Budget budget){
		return budgetService.putBudget(budget);
	}
	
	@DeleteMapping(path = "/delete-budget/id/{id}")
	public ResponseEntity<Budget> deleteBudget(@Valid @PathVariable Integer id){
		return budgetService.deleteBudget(id);
	}
}
