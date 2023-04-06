package com.blohny.article.service;

import com.blohny.article.domain.Board;
import com.blohny.article.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {

        return boardRepository.findAll();
    }
}
