package com.blohny.article.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String filename;

    private String filepath;
}
