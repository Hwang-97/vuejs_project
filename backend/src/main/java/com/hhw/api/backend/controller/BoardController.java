package com.hhw.api.backend.controller;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.repository.BoardDetailRepository;
import com.hhw.api.backend.repository.BoardRepository;
import com.hhw.api.backend.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(Log.class);
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardDetailRepository boardDetailRepository;

    @RequestMapping("/api/boardList")
    public List<Board> getBoardList(@RequestParam(required = false) String typeFlag,
                                    @RequestParam(required = false) String content) {
        log.info("getBoardList - typeFlag: {}, content: {}", typeFlag, content);
        List<Board> boardList = new ArrayList<Board>();
        if(content == null){
            boardList = boardRepository.findAll();
        }else {
            if (typeFlag.equals("title")) {
                boardList = boardRepository.findByTitleContaining(content);
            } else if (typeFlag.equals("content")) {
                boardList = boardRepository.findByContentContaining(content);
            }
        }
        return boardList;
    }
}
