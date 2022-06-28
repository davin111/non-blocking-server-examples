package com.davin111.exampleblocking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContentsDto {
    private List<ContentDto> contents;
}
