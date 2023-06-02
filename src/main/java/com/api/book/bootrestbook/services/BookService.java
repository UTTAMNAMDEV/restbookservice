package com.api.book.bootrestbook.services;
//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.api.book.bootrestbook.dao.BookRepository;
//import com.api.book.bootrestbook.entitis.Author;
import com.api.book.bootrestbook.entitis.Book;

@Component
public class BookService {
    @Autowired
   private BookRepository repo;
    // private  static List<Book> list= new ArrayList<>();
    // static{
    //     list.add(new Book(11, "java", "uttam namdev"));
    //     list.add(new Book(12, "Python", "Namaji")); 
    //      list.add(new Book(13, "DSA", "Namdevji"));  
    //      list.add(new Book(14, "c++", "Uttamji"));
    // }


    // get all books
    public List<Book> getAllBook()
    {
        List<Book> list=(List<Book>)this.repo.findAll();
        return list;
    }


    //get only single book by id 
    public Book getBookById(int id)
    {
        Book book=null;
        try {
           // book=list.stream().filter(e->e.getId()==id).findFirst().get();
           // return book;  
           book=this.repo.findById(id); 
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();;
        }
       return book;  
    }


    public Book addbook(Book b) 
    {
        //list.add(b); 
            //return b;
            Book result=this.repo.save(b);
            return result;
    }


    public void deleteBook(int bid) 
    {
        //list=list.stream().filter(book->book.getId()!=bid
            // if(book.getId()!=bid) {        // ye vala full slon  hai uper vala ek single line ka code hai to atomatic he desaid ker leta hai true hoga ya false
            //     return true;
            // }
            // else{
            //     return false;
            // }
        //).collect(Collectors.toList());
        repo.deleteById(bid);

    }

    public void updateBook(Book book, int bookid) 
    {
    //   list=list.stream().map(b->{
    //         if(b.getId()==bookid)
    //         {
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
       book.setId(bookid);
       repo.save(book); // update or save dono ek he kam krete hai ....
    }
}
