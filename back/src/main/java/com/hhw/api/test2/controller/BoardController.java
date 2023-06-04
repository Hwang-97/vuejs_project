package com.hhw.api.test2.controller;

import com.hhw.api.test2.entity.Board;
import com.hhw.api.test2.repository.BoardDetailRepository;
import com.hhw.api.test2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardDetailRepository boardDetailRepository;

    @RequestMapping("/api/boardList")
    public List<Board> getBoardList(@RequestParam("keyword") String keyword){
        System.out.println(keyword);
        List<Board> boardList = boardRepository.findByTitleContaining(keyword);
        return boardList;
    }
}
