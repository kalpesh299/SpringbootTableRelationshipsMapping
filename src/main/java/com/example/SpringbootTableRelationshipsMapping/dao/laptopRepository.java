package com.example.SpringbootTableRelationshipsMapping.dao;

import com.example.SpringbootTableRelationshipsMapping.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface laptopRepository extends JpaRepository<Laptop,Integer> {
}
