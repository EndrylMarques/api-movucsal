package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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
            return new ResponseEntity(csvService.readPontoCsvFile(file), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PostMapping("/upload-caminho-csv")
    ResponseEntity<Caminho> uploadCaminhoCSVFile(@RequestParam("caminho") MultipartFile file ) {
        try {
            return new ResponseEntity(csvService.readCaminhoCsvFile(file), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
