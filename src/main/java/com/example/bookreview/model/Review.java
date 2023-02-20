package com.example.bookreview.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Review{
    @Id
    @Column(name="reviewer")
    private String reviewer;
    @OneToOne
    @JoinColumn(name="book_id",referencedColumnName="id")
    private Book book;
    @Column(name="rating")
    private Integer rating;


}