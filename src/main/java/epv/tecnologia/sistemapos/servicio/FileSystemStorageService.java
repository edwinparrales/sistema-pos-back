package epv.tecnologia.sistemapos.servicio;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileSystemStorageService implements StorageService{
    @Value("${media.location}")
    private String mediaLocation;
    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() {
        rootLocation = Paths.get(mediaLocation);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String store(MultipartFile file) {
        try {


        if(file.isEmpty()){
            throw new RuntimeException("El archivo esta vacio");
        }

        String fileName = file.getOriginalFilename();
        Path destinationFile = rootLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();

        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);

        }
        return fileName;
    }catch (RuntimeException | IOException e){
        throw  new RuntimeException("No se puede leer el archiv"+ e.getMessage());
    }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() | resource.isReadable()){
                return resource;
            }else{

                throw  new RuntimeException("No se puede leer el archivo"+filename);
            }

        }catch (MalformedURLException mf){
            throw  new RuntimeException("Url mal formada"+mf.getMessage());
        }
    }
}
