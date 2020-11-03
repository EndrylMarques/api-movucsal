package br.com.movucsal.controller;

import br.com.movucsal.entity.Caminho;
import br.com.movucsal.entity.Ponto;
import br.com.movucsal.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CsvController {

    private CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService){
        this.csvService = csvService;
    }

    @PostMapping("/upload-ponto-csv")
    ResponseEntity<Ponto> uploadPontoCSVFile(@RequestParam("pontos") MultipartFile file ) {
        try {
            return new ResponseEntity(csvService.ReadPontoCsvFile(file), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PostMapping("/upload-caminho-csv")
    ResponseEntity<Caminho> uploadCaminhoCSVFile(@RequestParam("caminho") MultipartFile file ) throws IOException {
        try {
            return new ResponseEntity(csvService.ReadCaminhoCsvFile(file), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
