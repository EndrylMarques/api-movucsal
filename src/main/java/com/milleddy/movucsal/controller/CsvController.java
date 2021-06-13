package com.milleddy.movucsal.controller;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.exceptions.MovUcsalException;
import com.milleddy.movucsal.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CsvController {

    private CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload-ponto-csv")
    public ResponseEntity<List<Ponto>> uploadPontoCSVFile(@RequestParam("pontos") MultipartFile file) {
        try {
            return ResponseEntity.ok(csvService.readPontoCsvFile(file));
        } catch (Exception e) {
            throw new MovUcsalException(
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/upload-caminho-csv")
    public ResponseEntity<List<Caminho>> uploadCaminhoCSVFile(@RequestParam("caminho") MultipartFile file) {
        try {
            return ResponseEntity.ok(csvService.readCaminhoCsvFile(file));
        } catch (Exception e) {
            throw new MovUcsalException(
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
