package com.example.bookreview.model;

import lombok.Data;
import lombok.Builder;


import javax.persistence.*;

@Data
@Entity
@Builder
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