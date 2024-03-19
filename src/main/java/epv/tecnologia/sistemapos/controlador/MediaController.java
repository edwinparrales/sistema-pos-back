package epv.tecnologia.sistemapos.controlador;

import epv.tecnologia.sistemapos.servicio.StorageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("api/media/")
@AllArgsConstructor
public class MediaController {

    private final StorageService storageService;
    private final HttpServletRequest request;
 @PostMapping("upload")
    public Map<String,String> uploadFile(@RequestParam("file") MultipartFile file){
       String path = storageService.store(file);
       String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
       String url = ServletUriComponentsBuilder
               .fromHttpUrl(host)
               .path("/media/")
               .path(path)
               .toUriString();
       return Map.of("url",url);
    }

    @GetMapping("{filename:.*}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE,contentType)
                .body(file);

    }

}