package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByTitleContaining(String keyword);

    List<Board> findByContentContaining(String keyword);

    @Query( value = "SELECT * FROM board WHERE ID = ?1", nativeQuery = true )
    Board findByIdContaining(String id);

    void deleteById(String id);
}