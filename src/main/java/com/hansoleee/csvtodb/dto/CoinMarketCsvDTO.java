package com.hansoleee.csvtodb.dto;

import com.hansoleee.csvtodb.domain.CoinMarket;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CoinMarketCsvDTO {

    @CsvBindByName(column = "market")
    private String no;

    @CsvBindByName(column = "korean_name")
    private String koreanName;

    @CsvBindByName(column = "english_name")
    private String englishName;

    public CoinMarket toEntity() {
        return new CoinMarket(this.no, this.koreanName, this.englishName);
    }
}
