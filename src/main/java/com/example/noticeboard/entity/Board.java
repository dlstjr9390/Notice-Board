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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="writer", nullable = false)
    private String writer;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="contents", nullable = false)
    private String contents;
    @Column(name="date")
    private Date date;

    public Board(BoardRequestDto boardrequestDto){
        this.title = boardrequestDto.getTitle();
        this.writer = boardrequestDto.getWriter();
        this.password = boardrequestDto.getPassword();
        this.contents = boardrequestDto.getContents();
        this.date = boardrequestDto.getDate();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.writer = boardRequestDto.getWriter();
        this.password = boardRequestDto.getPassword();
        this.contents = boardRequestDto.getContents();
        this.date = boardRequestDto.getDate();
    }

}
