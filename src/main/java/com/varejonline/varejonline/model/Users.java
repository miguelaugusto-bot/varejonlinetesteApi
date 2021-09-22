package com.varejonline.varejonline.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	
	@NotNull
	@NotBlank
	private String email_user;
	
	@NotNull
	@NotBlank
	@Size(min = 10, max = 100)
	private String password_user;
	
	private String type_user;
	
	private Boolean loggedIn;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("user")
	private List<Budget> budget;
	
	public Users(){
		
	}
	
	public Users(Integer id_user, String email_user, String password_user, String type_user) {
		super();
		this.id_user =  id_user;
		this.email_user = email_user;
		this.password_user = password_user;
		this.type_user = type_user;
		this.loggedIn = false;
	}

	public Integer getId() {
		return id_user;
	}

	public void setId(Integer id) {
		this.id_user = id;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String type_user) {
		this.type_user = type_user;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public List<Budget> getBudget() {
		return budget;
	}

	public void setBudget(List<Budget> budget) {
		this.budget = budget;
	}

	public Boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users user = (Users) o;
        return Objects.equals(email_user, user.email_user) &&
                Objects.equals(password_user, user.password_user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_user, email_user, password_user, 
                            loggedIn);
    }

	

}
