package br.com.movucsal.service;


import br.com.movucsal.entity.Caminho;
import br.com.movucsal.entity.Ponto;
import br.com.movucsal.repository.CaminhoRepository;
import br.com.movucsal.repository.PontoRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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

    public List<Ponto> ReadPontoCsvFile(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<Ponto> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Ponto.class)
                    .build();

            List<Ponto> pontos = csvToBean.parse();

            return pontoRepository.saveAll(pontos);
        } catch (Exception e){
            throw new IOException(e.getMessage());
        }
    }

    public List<Caminho> ReadCaminhoCsvFile(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<Caminho> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Caminho.class)
                    .build();

            List<Caminho> caminhos = csvToBean.parse();

            return caminhoRepository.saveAll(caminhos);
        }catch (Exception e){
            throw new IOException(e.getMessage());
        }
    }
}
