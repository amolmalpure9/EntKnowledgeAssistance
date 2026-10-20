package com.eka.service;

import com.eka.exceptions.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {
//        try {
//            if (file.isEmpty()) {
//                throw new StorageException("Failed to store empty file.");
//            }
//            Path destinationFile = this.rootLocation.resolve(
//                            Paths.get(file.getOriginalFilename()))
//                    .normalize().toAbsolutePath();
//            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
//                // This is a security check
//                throw new StorageException(
//                        "Cannot store file outside current directory.");
//            }
//            try (InputStream inputStream = file.getInputStream()) {
//                Files.copy(inputStream, destinationFile,
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        }
//        catch (Exception e) {
//            throw new StorageException("Failed to store file.", e);
//        }
    }

    @Override
    public Stream<Path> loadAll() {
        return Stream.empty();
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

}
