package com.varejonline.varejonline.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_budget")
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_budget;
	
	private String name_client;
	
	private String address_client;
	
	private Integer valid_budget;
	
	private String obs_budget;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime generated_budget = LocalDateTime.now();
	
	@ManyToOne
	@JsonIgnoreProperties("budget")
	private Users user;
	
	@OneToMany(mappedBy = "budget", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("budget")
	private List<Itens> itens = new ArrayList<>();
	
	public Budget() {
		
	}
	
	public Budget(Integer id_budget, String name_client, String address_client, Double value_total, Integer valid_budget, Integer qtd_itens, Integer qtd_parts, Date generated_budget) {
		super();
	}

	public Integer getId_budget() {
		return id_budget;
	}

	public void setId_budget(Integer id_budget) {
		this.id_budget = id_budget;
	}

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public String getAddress_client() {
		return address_client;
	}

	public void setAddress_client(String address_client) {
		this.address_client = address_client;
	}

	public Integer getValid_budget() {
		return valid_budget;
	}

	public void setValid_budget(Integer valid_budget) {
		this.valid_budget = valid_budget;
	}

	public LocalDateTime getGenerated_budget() {
		return generated_budget;
	}

	public void setGenerated_budget(LocalDateTime generated_budget) {
		this.generated_budget = generated_budget;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Itens> getItens() {
		return itens;
	}

	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}

	public String getObs_budget() {
		return obs_budget;
	}

	public void setObs_budget(String obs_budget) {
		this.obs_budget = obs_budget;
	}

	public int getQtd_Itens(){
		int qtd_itens = itens.size();
		return qtd_itens;
	}
	
	public int getQtd_Parts(){
		int  qtd_parts_total = 0;
		for(Itens itens: itens){
			qtd_parts_total = qtd_parts_total + itens.getQtd_parts();
		}
		return qtd_parts_total;
	}
	
	public Double getTotal(){
		Double total = 0.0;
		for(Itens itens: itens) {
			total =  total + itens.getSustotal();
		}
		return total;
	}
	
	
	
}
