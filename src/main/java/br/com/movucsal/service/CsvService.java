package br.com.movucsal.service;


import br.com.movucsal.entity.Ponto;
import br.com.movucsal.repository.PontoRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class CsvService {

    private static PontoRepository pontoRepository;

    public CsvService(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public static void ReadPontoCsvFile(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<Ponto> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Ponto.class)
                    .build();

            List<Ponto> pontos = csvToBean.parse();

            for (Ponto ponto : pontos){
                System.out.println(ponto.getDescricao());
            }

            pontoRepository.saveAll(pontos);
        }
    }
}
