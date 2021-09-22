package com.varejonline.varejonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varejonline.varejonline.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Integer>{

}
