package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDetailRepository extends JpaRepository<BoardDetail, Integer> {
    BoardDetail findByIdContaining(String keyword);
}