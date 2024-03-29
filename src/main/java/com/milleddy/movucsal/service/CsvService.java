package com.milleddy.movucsal.service;

import com.milleddy.movucsal.entity.Caminho;
import com.milleddy.movucsal.entity.Ponto;
import com.milleddy.movucsal.repository.CaminhoRepository;
import com.milleddy.movucsal.repository.PontoRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


@Service
public class CsvService {

    private PontoRepository pontoRepository;
    private CaminhoRepository caminhoRepository;

    @Autowired
    public CsvService(PontoRepository pontoRepository, CaminhoRepository caminhoRepository) {
        this.pontoRepository = pontoRepository;
        this.caminhoRepository = caminhoRepository;
    }

    public List<Ponto> readPontoCsvFile(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            var csvToBean = new CsvToBeanBuilder<Ponto>(reader)
                    .withType(Ponto.class)
                    .build();

            List<Ponto> pontos = csvToBean.parse();

            return pontoRepository.saveAll(pontos);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public List<Caminho> readCaminhoCsvFile(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            var csvToBean = new CsvToBeanBuilder<Caminho>(reader)
                    .withType(Caminho.class)
                    .build();

            var caminhos = csvToBean.parse();
            var updatedCaminhos = new ArrayList<Caminho>();
            for (Caminho caminho : caminhos) {
                var ponto = pontoRepository.findByCodigo(caminho.getPontoOrigemCodigo());
                caminho.setPontoOrigem(ponto);

                ponto = pontoRepository.findByCodigo(caminho.getPontoDestinoCodigo());
                caminho.setPontoDestino(ponto);

                updatedCaminhos.add(caminho);
            }

            return caminhoRepository.saveAll(updatedCaminhos);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}
