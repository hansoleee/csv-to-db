package com.hansoleee.csvtodb.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ItemForm {

    private MultipartFile csvFile;
}
