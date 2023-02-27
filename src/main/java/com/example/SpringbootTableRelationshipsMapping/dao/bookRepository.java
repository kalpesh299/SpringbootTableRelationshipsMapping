package com.example.SpringbootTableRelationshipsMapping.dao;

import com.example.SpringbootTableRelationshipsMapping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book,Integer> {
}
