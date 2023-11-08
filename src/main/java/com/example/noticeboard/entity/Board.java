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

    public Board(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
        this.date = requestDto.getDate();
    }

}
