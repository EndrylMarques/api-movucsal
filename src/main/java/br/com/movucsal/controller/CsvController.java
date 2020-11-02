package br.com.movucsal.controller;

import br.com.movucsal.service.CsvService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class CsvController {

    @PostMapping("/upload-ponto-csv")
    public void uploadPontoCSVFile(@RequestParam("pontos") MultipartFile file ) throws IOException {
        if (!file.isEmpty()) {
            CsvService.ReadPontoCsvFile(file);
        }
    }

    @PostMapping("/upload-caminho-csv")
    public void uploadCaminhoCSVFile(@RequestParam("caminho") MultipartFile file ) throws IOException {
        if (!file.isEmpty()) {
            CsvService.ReadCaminhoCsvFile(file);
        }
    }
}
