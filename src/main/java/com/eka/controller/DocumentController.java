package com.eka.controller;

import com.eka.beans.Employee;
import com.eka.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentController {

    @Autowired
    StorageServiceImpl storageServiceImpl;

    @PostMapping("/uploadDocument")
    public Employee uploadDocument(@RequestParam("file") MultipartFile multipartFile) {

        storageServiceImpl.store(multipartFile);
        return new Employee();
    }

    @GetMapping("/retrieveDocuments")
    public void saveEmpDetails(Employee employee) {
        System.out.println("Saved to DB");
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageServiceImpl.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}

