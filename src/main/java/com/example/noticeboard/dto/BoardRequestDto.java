package com.example.noticeboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class BoardRequestDto {
    private Long id;
    private String title;
    private String writer;
    private String password;
    private String contents;
}
