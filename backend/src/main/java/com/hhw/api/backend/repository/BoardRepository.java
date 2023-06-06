package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByTitleContaining(String keyword);
}