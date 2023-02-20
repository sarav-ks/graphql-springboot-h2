package com.example.bookreview.controller;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import com.example.bookreview.model.Author;
import com.example.bookreview.model.Review;
import com.example.bookreview.model.*;
import com.example.bookreview.repository.AuthorRepository;
import com.example.bookreview.repository.BookRepository;
import com.example.bookreview.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@Controller
@AllArgsConstructor
public class BookController{
    private final BookRepository bookRepo;
    private final AuthorRepository authRepo;
    private final ReviewRepository reviewRepo;

    @QueryMapping
    public List<Book> recommendBook(@Argument String authorName){
        return null;
    }

    @MutationMapping
    public Book createBook(@Argument String name , @Argument String genre, @Argument String sample , @Argument String awards, @Argument List<Long> authors){
        List<Author> alist = authors.stream().map(e->Author.builder().id(e).build()).collect(Collectors.toList());
        Book newBook = Book.builder().name(name).genre(genre).sample(sample).awards(awards).authors(alist).build();
        return newBook;
    }

    @MutationMapping
    public Book updateBook(@Argument Long id ,@Argument String name, @Argument String genre, @Argument String sample , @Argument String awards, @Argument List<Long> authors){
        return null;
    }

    @MutationMapping
    public Author createAuthor(@Argument String name , @Argument String email, @Argument String city , @Argument String state){
        return null;
    }

    @MutationMapping
    public Review createReview(@Argument Long book , @Argument String reviewer, @Argument Integer rating){
        return null;
    }

}