package com.varejonline.varejonline.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varejonline.varejonline.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	
}
