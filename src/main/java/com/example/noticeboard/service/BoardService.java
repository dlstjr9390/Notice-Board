package com.example.noticeboard.service;

import com.example.noticeboard.Repositoty.BoardRepository;
import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(JdbcTemplate jdbcTemplate) {
        this.boardRepository= new BoardRepository(jdbcTemplate);
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);

        Board insertBoard = boardRepository.insert(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoards(){
        return boardRepository.findAll();
    }

    public BoardResponseDto detailBoard(Long id){
        Board board = boardRepository.view(id);
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);
        return boardResponseDto;
    }

    public Long updateBoard(Long id,BoardRequestDto boardRequestDto){

        Board board = boardRepository.findById(id);
        if(board != null){
            if(board.getPassword().equals(boardRequestDto.getPassword())) {
                boardRepository.update(id,boardRequestDto);
                return id;
            } else{
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }

    }

    public Long deleteBoard(Long id, BoardRequestDto boardRequestDto) {

        Board board = boardRepository.findById(id);
        if(board != null){
            if(board.getPassword().equals(boardRequestDto.getPassword())) {
                boardRepository.delete(id);
                return id;
            } else{
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            }
        } else{
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    
}
