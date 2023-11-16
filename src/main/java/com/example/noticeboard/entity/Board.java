package com.example.noticeboard.entity;

import com.example.noticeboard.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="board")
@NoArgsConstructor
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="writer", nullable = false)
    private String writer;
    @Column(name="contents", nullable = false)
    private String contents;


    public Board(BoardRequestDto boardrequestDto){
        this.title = boardrequestDto.getTitle();
        this.writer = boardrequestDto.getWriter();
        this.contents = boardrequestDto.getContents();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.writer = boardRequestDto.getWriter();
        this.contents = boardRequestDto.getContents();
    }

}
