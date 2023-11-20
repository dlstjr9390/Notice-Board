package com.example.noticeboard.controller;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardListResponseDto;
import com.example.noticeboard.dto.DetailBoardResponseDto;
import com.example.noticeboard.entity.NowUser;
import com.example.noticeboard.entity.NowUser;
import com.example.noticeboard.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    // todo 할일 제목, 할일 내용, 작성일 username = 로그인된 사용자
    @PostMapping("/board")
    public BoardListResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    //todo 회원별로
    // 제목, 작성자, 작성일, 완료여부
    @GetMapping("/board")
    public List<BoardListResponseDto> getBoards(){
        return boardService.getBoards();
    }

    @GetMapping("/board/{id}")
    public DetailBoardResponseDto detailBoard(@PathVariable Long id){
        return boardService.detailBoard(id);
    }

    //todo 제목, 작성내용 수정
    // 토큰 검사후 유효하면서 해당 작성자만 수정 가능 후 정보 반환

    @PutMapping("/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(id,boardRequestDto);
    }


    //todo 할일카드 완료 기능
    // 유효토큰, 작성자만 완료 가능, 목록 조회시 완료 여부 필드가 TRUE
    @PutMapping("/board/complete/{id}")
    public Long completeBoard(@PathVariable Long id){
        return boardService.completeBoard(id);
    }
}
