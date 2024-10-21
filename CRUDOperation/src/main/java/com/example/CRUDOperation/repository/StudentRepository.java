package com.example.CRUDOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDOperation.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	
}
