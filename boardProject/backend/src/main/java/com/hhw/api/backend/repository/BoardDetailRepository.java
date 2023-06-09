package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardDetailRepository extends JpaRepository<BoardDetail, Integer> {
    @Query( value = "SELECT * FROM board_detail WHERE ID = ?1", nativeQuery = true )
    BoardDetail findByIdContaining(String id);

    void deleteById(String id);

    Optional<BoardDetail> findById(String id);
}