package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.MyModel;

public interface MyRepository extends JpaRepository<MyModel, Integer>{
	
	@Query("SELECT e FROM MyModel e WHERE e.name=:name and e.password = :password")
	MyModel findByName(String name, String password);


}
