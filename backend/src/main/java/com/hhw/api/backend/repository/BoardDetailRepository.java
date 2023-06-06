package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.BoardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDetailRepository extends JpaRepository<BoardDetail, Integer> {
}