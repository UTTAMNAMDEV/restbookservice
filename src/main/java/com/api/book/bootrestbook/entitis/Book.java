package com.api.book.bootrestbook.entitis;
//import org.hibernate.mapping.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity// for set a id in database......................../
@Table(name = "books")// for create table auto in Database...../
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// for Auto inccrement....
    private int id;
    private String title;

   @OneToOne(cascade = CascadeType.ALL)
   @JsonManagedReference
    private Author author;

    public Book() {
    }

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
        
    }
   
}
