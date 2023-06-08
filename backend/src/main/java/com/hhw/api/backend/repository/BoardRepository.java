package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Board;
import com.hhw.api.backend.entity.BoardDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Object> findByTitleContaining(String keyword, Pageable pageable);
    Optional<Board> findById(String id);
    @Query( value = "SELECT COUNT(*) AS TOT FROM board WHERE title like ?1", nativeQuery = true )
    Integer findByTitleCount(String keyword);

    List<Object> findByContentContaining(String keyword, Pageable pageable);
    @Query( value = "SELECT COUNT(*) AS TOT FROM board WHERE content like ?1", nativeQuery = true )
    Integer findByContentCount(String keyword);

    @Query( value = "SELECT * FROM board WHERE ID = ?1", nativeQuery = true )
    Board findByIdContaining(String id);

    void deleteById(String id);
}