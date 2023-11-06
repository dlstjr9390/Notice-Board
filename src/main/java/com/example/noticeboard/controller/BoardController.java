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

    @GetMapping("/board/{id}")
    public BoardResponseDto detailBoard(@PathVariable Long id){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.detailBoard(id);
    }

    @PutMapping("/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.updateBoard(id,boardRequestDto);
    }

    @DeleteMapping("/board/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto ){
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.deleteBoard(id,boardRequestDto);
    }
}
