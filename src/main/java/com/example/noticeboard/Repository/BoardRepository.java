package com.example.noticeboard.Repository;

import com.example.noticeboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByOrderByWriterAscModifiedAtDesc();
    Board findBoardById(Long id);
}
