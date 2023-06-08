package com.hhw.api.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String author;
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "is_deletable")
    private Boolean isDeletable = true;
}