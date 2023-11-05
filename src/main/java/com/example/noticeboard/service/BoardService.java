package com.example.noticeboard.service;

import com.example.noticeboard.Repositoty.BoardRepository;
import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BoardService {
    private final JdbcTemplate jdbcTemplate;

    public BoardService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);

        BoardRepository boardRepository = new BoardRepository(jdbcTemplate);
        Board insertBoard = boardRepository.insert(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoards(){
        BoardRepository boardRepository = new BoardRepository(jdbcTemplate);
        return boardRepository.findAll();
    }

    //TODO 선택 게시글 보기 : id 넘기고 쿼리문으로 해당하는 내용 가져오기
    public Long detailBoard(Long id, BoardRequestDto boardRequestDto){
        BoardRepository boardRepository = new BoardRepository(jdbcTemplate);

        Board board = boardRepository.findById(id);
        if(board != null){
            boardRepository.view(id, boardRequestDto);

            return id;
        } else{
            throw new IllegalArgumentException("선택한 글은 존재하지 않습니다.");
        }
    }

    //TODO 업데이트 마저 구현 비밀번호 비교하는 로직짜기
    public Long updateMemo(Long id,BoardRequestDto requestDto){
        BoardRepository boardRepository = new BoardRepository(jdbcTemplate);

        Board board = boardRepository.findById(id);
        if(board != null){
            boardRepository.update();
        }
    }

    //TODO 딜리트 구현하기
    
}
