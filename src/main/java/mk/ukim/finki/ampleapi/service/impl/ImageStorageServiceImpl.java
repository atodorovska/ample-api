package mk.ukim.finki.ampleapi.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import mk.ukim.finki.ampleapi.config.StorageConfiguration;
import mk.ukim.finki.ampleapi.domain.exceptions.StorageException;
import mk.ukim.finki.ampleapi.service.ImageStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {

    private final Path rootLocation;

    public ImageStorageServiceImpl(StorageConfiguration properties) {
        this.rootLocation = Paths.get(properties.LOCATION);
    }

    @Override
    public void store(MultipartFile file) throws StorageException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) throws FileNotFoundException {
        try {
            Path file = load(filename);
            String uri = file.toUri().getPath().replace("/", "\\");
            uri = uri.substring(1, uri.length());
            File fileUri = new File(uri);
            Resource resource = new UrlResource(fileUri.toURI());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException();
            }
        }
        catch (MalformedURLException e) {
            throw new FileNotFoundException();
        }
    }
}
