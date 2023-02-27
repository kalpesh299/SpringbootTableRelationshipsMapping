package com.example.SpringbootTableRelationshipsMapping.controller;

import com.example.SpringbootTableRelationshipsMapping.dao.studentRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Book;
import com.example.SpringbootTableRelationshipsMapping.service.bookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {

    @Autowired
    bookService bookservice;

    @Autowired
    studentRepository studentrepository;

    @PostMapping("/addbook")
    public ResponseEntity<String>addBook(@RequestBody String book){
        Book newbook=setBook(book);
       int bookid=bookservice.addBook(newbook);
        return new ResponseEntity<>("book has been save with id"+bookid, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookservice.getBooks();
    }

    @DeleteMapping("/deletebook")
    public ResponseEntity<String> deleteBook(@RequestParam int id){
        bookservice.deleteBook(id);
        return new ResponseEntity<>("book deleted with id "+id,HttpStatus.OK);
    }

    @PutMapping("updatebook")
    public ResponseEntity<String>updateBook(@RequestParam int id,@RequestBody String book){
        Book newBook=setBook(book);
        bookservice.updateBook(id,newBook);
        return new ResponseEntity<>("book updated with id "+id,HttpStatus.OK);
    }

    private Book setBook(String book) {
        JSONObject json=new JSONObject(book);
        Book newbook=new Book();
        newbook.setTitle(json.getString("title"));
        newbook.setAuthor(json.getString("author"));
        newbook.setDescription(json.getString("description"));
        newbook.setPrice(json.getString("price"));
        newbook.setStudent(studentrepository.findById(json.getInt("student")).get());

        return newbook;
    }

}
