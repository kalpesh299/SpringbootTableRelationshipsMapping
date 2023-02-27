package com.example.SpringbootTableRelationshipsMapping.dao;

import com.example.SpringbootTableRelationshipsMapping.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Course,Integer> {
}
