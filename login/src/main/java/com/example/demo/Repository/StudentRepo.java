package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Students;


public interface StudentRepo extends JpaRepository<Students, Long> {
	public Students findByEmail(String email);

}
