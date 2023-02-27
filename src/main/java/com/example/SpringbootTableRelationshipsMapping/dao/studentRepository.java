package com.example.SpringbootTableRelationshipsMapping.dao;

import com.example.SpringbootTableRelationshipsMapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student,Integer> {

}
