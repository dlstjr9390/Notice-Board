package com.example.noticeboard.controller;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
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


    // todo 할일 제목, 할일 내용, 작성일
    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    //todo 회원별로
    // 제목, 작성자, 작성일, 완료여부
    @GetMapping("/board")
    public List<BoardResponseDto> getBoards(){
        return boardService.getBoards();
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto detailBoard(@PathVariable Long id){
        return boardService.detailBoard(id);
    }

    //todo 제목, 작성내용 수정
    // 토큰 검사후 유효하면서 해당 작성자만 수정 가능 후 정보 반환
//    @PutMapping("/board/{id}")
//    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
//        return boardService.updateBoard(id,boardRequestDto);
//    }
//
//
//    @DeleteMapping("/board/{id}")
//    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto ){
//        return boardService.deleteBoard(id,boardRequestDto);
//    }

    //todo 할일카드 완료 기능
    // 유효토큰, 작성자만 완료 가능, 목록 조회시 완료 여푸 필드가 TRUE

    //todo 댓글 작성
    // 유효 토큰 , 선택한 할일이 DB에 있는지 확인, 그 후 댓글 등록, 반환

    //todo 댓글 수정
    // 유효 토큰, 해당 작성자, 선택한 댓글이 DB에 있는지 확인, 그 후 수정, 반환

    //todo 댓글 삭제
    // 유효 토큰, DB 확인 , 댓글 삭제, 성공메시지, 상태코드 반환

}
