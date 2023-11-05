package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Board;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String password;
    private String contents;
    private Date date;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.contents = board.getContents();
        this.date = board.getDate();
    }

    public BoardResponseDto(Long id, String title, String writer, String contents, Date date) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.date = date;
    }
}
