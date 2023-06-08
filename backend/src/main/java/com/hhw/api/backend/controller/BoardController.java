package com.hhw.api.backend.controller;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import com.hhw.api.backend.repository.BoardDetailRepository;
import com.hhw.api.backend.repository.BoardRepository;
import com.hhw.api.backend.util.Log;
import com.hhw.api.backend.util.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(Log.class);
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardDetailRepository boardDetailRepository;

    @GetMapping("")
    public List<Object> getBoardList(@RequestParam(required = false) String typeFlag,
                                    @RequestParam(required = false) String searchText,
                                    Pageable pageable) {
        List<Object> boardList = new ArrayList<>();
        int tot = boardRepository.getTotalElements();
        if (typeFlag.equals("title")) {
            boardList = boardRepository.findByTitleContaining(searchText, pageable);
        } else if (typeFlag.equals("content")) {
            boardList = boardRepository.findByContentContaining(searchText, pageable);
        }
        boardList.add(0,tot);

        return boardList;
    }

    @GetMapping("/detail")
    public HashMap<String , Object> boardDetail(@RequestParam(required = false) String id) {
        log.info("boardDetail - id : {}", id);
        BoardDetail detail = new BoardDetail();
        Board board = new Board();
        HashMap<String , Object> resultMap = new HashMap<String , Object>();
        if(id != null){
            detail = boardDetailRepository.findByIdContaining(id);
            board = boardRepository.findByIdContaining(id);
            resultMap.put("id",detail.getId());
            resultMap.put("content",detail.getDetailText());
            resultMap.put("title",board.getTitle());
            resultMap.put("author",board.getAuthor());
            resultMap.put("createAt",board.getCreatedAt());
            resultMap.put("isDeletable",board.getIsDeletable());
            log.info("boardDetail - detail : {}", resultMap.toString());
        }
        return resultMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("")
    public void deleteBoard(@RequestParam(required = false) String id){
        HashMap<String , Object> resultMap = new HashMap<String , Object>();
        try {
            if (id != null) {
                boardDetailRepository.deleteById(id);
                boardRepository.deleteById(id);
            }
        }catch(Exception e){
            throw e;
        }
    }
}
