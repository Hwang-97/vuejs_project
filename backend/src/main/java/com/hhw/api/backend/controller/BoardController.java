package com.hhw.api.backend.controller;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.repository.BoardDetailRepository;
import com.hhw.api.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardDetailRepository boardDetailRepository;

    @RequestMapping("/api/boardList")
    public List<Board> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }
}
