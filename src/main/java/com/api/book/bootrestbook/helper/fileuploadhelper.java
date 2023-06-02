package com.api.book.bootrestbook.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadhelper {
    // satic path
    //public final String UPLOAD_DIR="C:\\Users\\Uttam Namdev\\Desktop\\sprinbootproject\\bootrestbook\\src\\main\\resources\\static\\image";

    //dyanmic path
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public  fileuploadhelper() throws IOException
    {
    }

    public boolean uploadfile(MultipartFile mpf){
        boolean f=false;
       
        try {
             // type 1 .... but large code...use inputStream/ filestream.......use stream apis.......
            // InputStream is= mpf.getInputStream();
            // bye data[]=new byte[is.available()];

            // //write and store data
            // FileInputStream fos= new FileInputStream(UPLOAD_DIR+File.separator+mpf.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();


            // Type 2   use N Io package for fast code like one line code ......

            Files.copy(mpf.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+mpf.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;

    }
    
}
