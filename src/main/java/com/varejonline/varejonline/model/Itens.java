package com.varejonline.varejonline.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_itens")
public class Itens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_itens;
	
	@NotBlank
	private String name_itens;
	
	private int qtd_parts;
	
	private Double value_uni;
	
	private Integer disc_itens;
	
	
	@ManyToOne
	@JsonIgnoreProperties("itens")
	private Budget budget;
	
	public Itens(){
		
	}
	
	public Itens(Integer id, String name_itens, Integer qtd_itens, Double valeu_uni, Integer disc_itens){
		super();
	}

	public Integer getId_itens() {
		return id_itens;
	}

	public void setId_itens(Integer id_itens) {
		this.id_itens = id_itens;
	}

	public String getName_itens() {
		return name_itens;
	}

	public void setName_itens(String name_itens) {
		this.name_itens = name_itens;
	}

	public int getQtd_parts() {
		return qtd_parts;
	}

	public void setQtd_parts(int qtd_itens) {
		this.qtd_parts = qtd_itens;
	}

	public Double getValue_uni() {
		return value_uni;
	}

	public void setValue_uni(Double value_uni) {
		this.value_uni = value_uni;
	}

	public Integer getDisc_itens() {
		return disc_itens;
	}

	public void setDisc_itens(Integer disc_itens) {
		this.disc_itens = disc_itens;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	public Double getSustotal(){
		 double itens_total = this.qtd_parts * this.value_uni;
		 return itens_total - (itens_total * (this.disc_itens / 100)); 
		
	}
	

}
