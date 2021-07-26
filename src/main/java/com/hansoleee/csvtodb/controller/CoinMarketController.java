package com.hansoleee.csvtodb.controller;

import com.hansoleee.csvtodb.dto.ItemForm;
import com.hansoleee.csvtodb.file.FileStore;
import com.hansoleee.csvtodb.file.UploadFile;
import com.hansoleee.csvtodb.repository.CoinMarketRepository;
import com.hansoleee.csvtodb.service.CoinMarketService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CoinMarketController {

    private final CoinMarketService coinMarketService;
    private final CoinMarketRepository coinMarketRepository;
    private final FileStore fileStore;

    @GetMapping
    public String newItem() {
        return "item-form";
    }

    @PostMapping
    public String saveItem(@ModelAttribute ItemForm form) throws IOException, CsvValidationException {
        UploadFile csvFile = fileStore.storeFile(form.getCsvFile());

        coinMarketService.readFile(csvFile);

        return "item-form";
    }
}
