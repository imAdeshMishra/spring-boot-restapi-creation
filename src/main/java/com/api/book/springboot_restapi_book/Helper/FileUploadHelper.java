package com.api.book.springboot_restapi_book.Helper;
import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;

@Controller
public class FileUploadHelper {
    // public final String UPLOAD_DIR = "C:\\Users\\Adesh\\SpringProjects\\FirstSpringBootProject\\springboot_restapi_book\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException{

    }

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;

        try {

            // InputStream is = multipartFile.getInputStream();
            // byte[] data =new byte[is.available()];

            // is.read(data);

            // // Write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();

            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            f=true;


        } catch (Exception e) {
        
            e.printStackTrace();
        }

        return f;
    }
}
