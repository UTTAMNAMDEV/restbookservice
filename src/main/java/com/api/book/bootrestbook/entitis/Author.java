package com.api.book.bootrestbook.entitis;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    @Column(name="Author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
     //@Column(name ="Author_Fname")
     private String firstname;
     //@Column(name ="Author_Lname")
     private String lastname;

     @OneToOne(mappedBy = "author")
     @JsonBackReference
     private Book book;

     

     public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author(){

     }

     
    public Author(int id, String firstname, String lastname, Book book) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.book = book;
    }

    // public Author(int id, String firstname, String lastname) {
    //     this.id = id;
    //     this.firstname = firstname;
    //     this.lastname = lastname;
    // }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @Override
    public String toString() {
        return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }

    

     


     
  
     

     
    
    
}
