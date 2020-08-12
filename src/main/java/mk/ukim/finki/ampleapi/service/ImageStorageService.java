package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.exceptions.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public interface ImageStorageService {

    void store(MultipartFile file) throws StorageException;

    Path load(String filename);
    Resource loadAsResource(String filename) throws FileNotFoundException;
}
