package com.hhw.api.backend.controller;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import com.hhw.api.backend.repository.BoardDetailRepository;
import com.hhw.api.backend.repository.BoardRepository;
import com.hhw.api.backend.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
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
                                    @RequestParam(required = false) String searchText) {
        log.info("getBoardList - typeFlag: {}, content: {}", typeFlag, searchText);
        List<Board> boardList = new ArrayList<Board>();
        if(searchText == null){
            boardList = boardRepository.findAll();
        }else {
            if (typeFlag.equals("title")) {
                boardList = boardRepository.findByTitleContaining(searchText);
            } else if (typeFlag.equals("content")) {
                boardList = boardRepository.findByContentContaining(searchText);
            }
        }
        return boardList;
    }

    @RequestMapping("/api/boardDetail")
    public BoardDetail boardDetail(@RequestParam(required = false) String id) {
        log.info("boardDetail - id : {}", id);
        BoardDetail detail = new BoardDetail();
        if(id != null){
            detail = boardDetailRepository.findByIdContaining(id);
            log.info("boardDetail - detail : {}", detail.toString());
        }
        return detail;
    }
}
