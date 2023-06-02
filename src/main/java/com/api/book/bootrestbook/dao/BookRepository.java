package com.api.book.bootrestbook.dao;
import com.api.book.bootrestbook.entitis.Book;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

//public interface BookRepository extends  CrudRepository<Book ,Integer>{
    public interface BookRepository extends JpaRepository<Book ,Integer>{
    public Book findById(int id);

}
