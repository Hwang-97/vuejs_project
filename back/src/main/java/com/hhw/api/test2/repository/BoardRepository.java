package com.hhw.api.test2.repository;

import com.hhw.api.test2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByTitleContaining(String keyword);
}