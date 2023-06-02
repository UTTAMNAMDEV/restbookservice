package com.api.book.bootrestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.fileuploadhelper;

@RestController
public class FileUploadcontroller {
    //call helper class method 
    @Autowired /// automatic object aajyga .........
    private fileuploadhelper fup;

    @PostMapping("/uploadfile")
    public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file){ // @Requestpram ka use file ko ans dene ke liy huaa hai
        // kuch tarke se file ko fatch kr sakte hai....
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        //validation
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file must be contain");
        }
        if(!file.getContentType().equals("image/jpeg"))
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image must be jpeg");

        }
        // file upload code........ek halper class bnake yha or call kr lenge...

        try {
            boolean f= fup.uploadfile(file);
            if(f){
                // for static path
               // return ResponseEntity.ok("file is successfully uploaded");

               //for dynamic path.....
               return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());


            }
        } catch (Exception e) {
            // TODO: handle exception
        }



        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("somthing went wrong try agin latter");
    }
    
}
