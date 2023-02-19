package com.example.bookreview.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Author{
    @Id
    
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="country")
    private String country;
}