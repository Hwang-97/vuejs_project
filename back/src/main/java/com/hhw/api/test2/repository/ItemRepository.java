package com.hhw.api.test2.repository;

import com.hhw.api.test2.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}