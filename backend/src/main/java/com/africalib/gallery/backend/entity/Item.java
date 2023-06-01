package com.africalib.gallery.backend.entity;

import lombok.Getter;
import javax.persistence.Id;

import javax.persistence.*;

@Getter
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String imgPath;

    @Column(length = 100)
    private int price;

    @Column(length = 100)
    private int discountPer;
}
