package com.example.noticeboard.service;

import com.example.noticeboard.Repository.BoardRepository;
import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardListResponseDto;
import com.example.noticeboard.dto.DetailBoardResponseDto;
import com.example.noticeboard.entity.Board;
import com.example.noticeboard.entity.NowUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository= boardRepository;
    }

//    public BoardService(ApplicationContext context) {
//      1.'Bean' 이름으로 가져오기
//      BoardRepository boardRepository = (BoardRepository) context.getBean("boardRepository");

//      2.'Bean' 클래스 형식으로 가져오기
//      BoardRepository boardRepository = context.getBean(BoardRepository.class);
//      this.boardRepository = boardRepository;
//    }

    public BoardListResponseDto createBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        Board insertBoard = boardRepository.save(board);
        BoardListResponseDto boardListResponseDto = new BoardListResponseDto(insertBoard);

        return boardListResponseDto;
    }

    public List<BoardListResponseDto> getBoards(){
        return boardRepository.findAllByOrderByWriterAscModifiedAtDesc().stream().map(BoardListResponseDto::new).toList();
    }

    public DetailBoardResponseDto detailBoard(Long id){
        Board board = boardRepository.findBoardById(id);
        DetailBoardResponseDto detailBoardResponseDto = new DetailBoardResponseDto(board);
        return detailBoardResponseDto;
    }

    @Transactional
    public Long updateBoard(Long id,BoardRequestDto boardRequestDto){
        Board board = findBoard(id);
        board.update(boardRequestDto);

        return id;
    }

    private Board findBoard(Long id){
        return boardRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 글은 존재하지 않습니다.")
        );
    }

    @Transactional
    public Long completeBoard(Long id) {
        Board board = findBoard(id);
        if(!board.isComplete()) {
            board.complete();
        } else{
            throw new IllegalArgumentException("이미 완료된 할일입니다.");
        }
            return id;

    }
}
