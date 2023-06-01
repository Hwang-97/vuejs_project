package com.africalib.gallery.backend.controller;

import com.africalib.gallery.backend.entity.Item;
import com.africalib.gallery.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/api/items")
    public List<Item> getItems(){
        List<Item> items = itemRepository.findAll();
        return items;
    }
}