package com.example.bookreview.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Review{
    @Id
    @Column(name="reviewer")
    private String reviewer;
    private Book book;
    @Column(name="rating")
    private Integer rating;


}