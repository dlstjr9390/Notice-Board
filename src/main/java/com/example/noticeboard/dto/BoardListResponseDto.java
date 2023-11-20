package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private String title;
    private String writer;
    private boolean isComplete;
    private LocalDateTime createAt;

    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.createAt = board.getCreatedAt();
        this.isComplete = board.isComplete();
    }

}
