package com.example.noticeboard.controller;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.service.BoardService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {
    private final JdbcTemplate jdbcTemplate;

    public BoardController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getBoards(){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.getBoards();
    }

    @GetMapping("/detail")
    public BoardResponseDto detailBoard(BoardResponseDto boardResponseDto){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.detailBoard(boardResponseDto.getId());
    }

    @PutMapping("/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        BoardService boardService = new BoardService(jdbcTemplate);

    }
}
