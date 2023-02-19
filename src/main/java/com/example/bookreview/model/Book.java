package com.example.bookreview.model;

import lombok.Data;
import java.util.*;

import javax.persistence.*;

@Data
@Entity
public class Book{
    @Id
    private Long id;
    @Column(name="bookName")
    private String name;
    private List<Author> authors;
    @Column(name="genre")
    private String genre;
    private List<String> awards;
    private String sample;
}