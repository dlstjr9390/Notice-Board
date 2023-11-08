package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Board;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String password;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.contents = board.getContents();
        this.createAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

}
