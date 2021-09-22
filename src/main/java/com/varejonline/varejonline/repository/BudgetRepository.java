package com.varejonline.varejonline.repository;

import org.springframework.stereotype.Repository;
import com.varejonline.varejonline.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer>{

	
}
