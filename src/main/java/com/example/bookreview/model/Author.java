package com.example.bookreview.model;

import lombok.Data;
import lombok.Builder;

import javax.persistence.*;

@Data
@Entity
@Builder
public class Author{
    @Id
    @GeneratedValue
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