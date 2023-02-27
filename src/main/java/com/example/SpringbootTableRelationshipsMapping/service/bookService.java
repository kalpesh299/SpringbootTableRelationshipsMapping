package com.example.SpringbootTableRelationshipsMapping.service;

import com.example.SpringbootTableRelationshipsMapping.dao.bookRepository;
import com.example.SpringbootTableRelationshipsMapping.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {

    @Autowired
    bookRepository bookreository;

    public int addBook(Book book){
        Book newbook=bookreository.save(book);
        return newbook.getID();
    }

    public List<Book> getBooks(){
        return bookreository.findAll();
    }
    public void deleteBook(int id){
        bookreository.deleteById(id);
    }

    public void updateBook(int id, Book _book) {
        Book book=bookreository.findById(id).get();
        book.setAuthor(_book.getAuthor());
        book.setTitle(_book.getTitle());
        book.setPrice(_book.getPrice());
        book.setDescription(_book.getDescription());
        book.setStudent(_book.getStudent());
        bookreository.save(book);
    }
}
