package school.sptech.testes;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @PostMapping(value = "/upload-jpeg", consumes = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<String> uploadJpeg(@RequestBody byte[] imageBytes) {
        try {
            String fileName = "/tmp/uploaded_image.jpg";
            File destinationFile = new File(fileName);

            try (FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
                outputStream.write(imageBytes);
            }

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Imagem JPEG salva com sucesso em: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @GetMapping(name = "/csv", produces = "text/csv")
    public ResponseEntity<Resource> downloadCsv() {
        String csv = csvGenerator();
        
        ByteArrayResource resource =
                new ByteArrayResource(csv.getBytes());

        return ResponseEntity.status(200)
                .contentLength(resource.contentLength())
                .body(resource);
    }

    private String csvGenerator() {
        StringBuilder csv = new StringBuilder();

        csv.append("Nome;Idade;Email\n");
        csv.append("João;25;joao@joao.com\n");
        csv.append("Maria;30;maria@maria.com\n");

        return csv.toString();
    }
}
