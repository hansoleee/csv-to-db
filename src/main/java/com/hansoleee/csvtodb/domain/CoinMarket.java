package com.hansoleee.csvtodb.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * no(part_no) 부품 번호
 * koreanName(korean_name) 한글 부품 이름
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class CoinMarket {

    @Id
    @Column(name = "market_no")
    private String no;

    private String koreanName;
    private String englishName;

    @Builder
    public CoinMarket(String no, String koreanName, String englishName) {
        this.no = no;
        this.koreanName = koreanName;
        this.englishName = englishName;
    }
}
