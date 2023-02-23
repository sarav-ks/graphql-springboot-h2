package com.example.bookreview.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name="book")
public class Book{
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="bookName")
    private String name;
    @OneToMany
    private List<Author> authors;
    @Column(name="genre")
    private String genre;
    @Column(name="awards")
    private String awards;
    @Column(name="sample")
    private String sample;
}