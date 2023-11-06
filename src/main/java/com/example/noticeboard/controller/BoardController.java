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
    private final BoardService boardService;

    public BoardController(JdbcTemplate jdbcTemplate) {
        this.boardService = new BoardService(jdbcTemplate);
    }

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getBoards(){
        return boardService.getBoards();
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto detailBoard(@PathVariable Long id){
        return boardService.detailBoard(id);
    }

    @PutMapping("/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(id,boardRequestDto);
    }

    @DeleteMapping("/board/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto ){
        return boardService.deleteBoard(id,boardRequestDto);
    }
}
