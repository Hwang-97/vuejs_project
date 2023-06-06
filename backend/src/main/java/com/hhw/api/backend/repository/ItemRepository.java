package com.hhw.api.backend.repository;

import com.hhw.api.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}