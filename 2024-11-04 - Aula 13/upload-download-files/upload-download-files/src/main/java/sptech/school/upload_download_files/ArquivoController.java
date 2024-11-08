package sptech.school.upload_download_files;

import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @PostMapping(value = "/upload-jpeg", consumes = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<String> uploadJpeg(@RequestBody byte[] imageBytes) {
        try {
            String fileName = "./uploaded_image.jpg";
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

    @PostMapping(value = "/upload-png", consumes = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<String> uploadPng(@RequestBody byte[] imageBytes) {
        try {
            String fileName = "./uploaded_image.png";
            File destinationFile = new File(fileName);

            try (FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
                outputStream.write(imageBytes);
            }

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Imagem PNG salva com sucesso em: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }




    @GetMapping(name = "/csv", produces = "text/csv")
//    @GetMapping(name = "/csv", produces = "application/pdf")
    public ResponseEntity<ByteArrayResource> downloadCsv() {
        String csv = csvGenerator();

        ByteArrayResource resource = new ByteArrayResource(csv.getBytes());

        return ResponseEntity.ok()
//                .contentLength(9)
                .contentLength(resource.contentLength())
                .body(resource);
    }

    private String csvGenerator() {
        StringBuilder csv = new StringBuilder();

        csv.append("Nome;Idade;Email;\n");
        csv.append("João;25;joao@joao.com;\n");
        csv.append("Maria;30;maria@maria.com;\n");

        return csv.toString();
    }
}
