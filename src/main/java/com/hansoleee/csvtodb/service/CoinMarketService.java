package com.hansoleee.csvtodb.service;

import com.hansoleee.csvtodb.domain.CoinMarket;
import com.hansoleee.csvtodb.dto.CoinMarketCsvDTO;
import com.hansoleee.csvtodb.file.UploadFile;
import com.hansoleee.csvtodb.repository.CoinMarketRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CoinMarketService {

    private final EntityManager em;
    private final CoinMarketRepository coinMarketRepository;

    public void readFile(UploadFile uploadFile) throws IOException, CsvValidationException {
        List<CoinMarketCsvDTO> result = new CsvToBeanBuilder<CoinMarketCsvDTO>(new FileReader("/home/lhs/csv/" + uploadFile.getStoreFilename()))
                .withType(CoinMarketCsvDTO.class).build().parse();

        coinMarketRepository.saveAll(toEntityList(result));
        System.out.println("result = " + result);
    }

    private List<CoinMarket> toEntityList(List<CoinMarketCsvDTO> coinMarketCsvDTOList) {
        return coinMarketCsvDTOList.stream().map(CoinMarketCsvDTO::toEntity).collect(Collectors.toList());
    }
}
