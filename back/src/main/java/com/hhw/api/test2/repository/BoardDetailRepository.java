package com.hhw.api.test2.repository;

import com.hhw.api.test2.entity.Board;
import com.hhw.api.test2.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDetailRepository extends JpaRepository<BoardDetail, Integer> {
}