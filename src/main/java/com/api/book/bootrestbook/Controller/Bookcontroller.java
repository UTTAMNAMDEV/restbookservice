package com.api.book.bootrestbook.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.boot.convert.DurationUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entitis.Book;
import com.api.book.bootrestbook.services.BookService;

// @Controller  use only normal spring controller....
@RestController  // iska use rest api vale project me krte h or iske use se @respone body vala annotation hat jayga mtlb jrurt nhi h likhne ki
public class Bookcontroller {
    @Autowired
    private BookService bookservice;
   // @RequestMapping(value = "/book", method = RequestMethod.GET ) //niche vala sort cut h
   @GetMapping("/book") // y tab use hoga jab method get use hora hai...
    // public Book getbook() {
    //     // Book book = new Book(0, null, null);
    //     // book.setId(12345);
    //     // book.setTitle("java book");
    //     // book.setAuthor("jamse ghosling");
    //     return book ;
    public ResponseEntity<List<Book>> getBook()//HTTP stutes bhjne ke liy list me store krnge or condtions lgyange.
    {
        List<Book> list=this.bookservice.getAllBook();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // return ResponseEntity.of(Optional.of(list)); for service not Db
        return ResponseEntity.status(HttpStatus.CREATED).body(list); // for databases.......
    }

    // for create book and find by id ....
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getbookbyid(@PathVariable("id") int id)
    {
        Book book=bookservice.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // for Add book......
    @PostMapping("/book")
    public ResponseEntity<Book> addbook(@RequestBody Book book)
    {
        Book b=null;
        try {
            b =this.bookservice.addbook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b)) ;
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }

    
    // for Delete book  by id....
    @DeleteMapping("/book/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid)
    {
        try {
            this.bookservice.deleteBook(bookid);
            System.out.println(bookid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  
        }   
    }


    // for updatebook......
    @PutMapping("/book/{bookid}")
    public ResponseEntity< Book> updateBook(@RequestBody Book book,@PathVariable("bookid") int bookid)
    {
        try {
            this.bookservice.updateBook(book,bookid);
        return ResponseEntity.ok().body(book);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
