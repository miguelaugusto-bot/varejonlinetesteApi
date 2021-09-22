package com.varejonline.varejonline;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.varejonline.varejonline.model.Users;
import com.varejonline.varejonline.repository.UsersRepository;

@SpringBootApplication
public class VarejonlineApplication implements CommandLineRunner{

	@Autowired
	private UsersRepository UserRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(VarejonlineApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception{
		Users vendedor = new Users(null,"vendedor@gmail.com","vendedor123", "VENDEDOR");
		Users gerente = new Users(null,"gerente@gmail.com","gerente123", "GERENTE");
		UserRepository.saveAll(Arrays.asList(vendedor, gerente));
	}

}
