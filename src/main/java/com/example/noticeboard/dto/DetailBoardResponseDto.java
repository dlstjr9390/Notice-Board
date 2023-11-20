package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DetailBoardResponseDto {
    private String title;
    private String writer;
    private String contents;
    private LocalDateTime createAt;

    public DetailBoardResponseDto(Board board){
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.contents = board.getContents();
        this.createAt = board.getCreatedAt();
    }
}
