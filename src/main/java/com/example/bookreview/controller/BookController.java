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
        Book createdBook = this.bookRepo.save(newBook);
        return createdBook;
    }

    @MutationMapping
    public Book updateBook(@Argument Long id ,@Argument String name, @Argument String genre, @Argument String sample , @Argument String awards, @Argument List<Long> authors){
        // Book searchBook = Book.builder().id(id).build();
        Book updateBook = this.bookRepo.getOne(id);
        if (name != null) updateBook.setName(name);
        if (genre != null) updateBook.setGenre(genre);
        if (sample != null) updateBook.setSample(sample);
        if (awards != null) updateBook.setAwards(awards);
        if (authors != null && authors.size() >0) {
            List<Author> alist = authors.stream().map(e->Author.builder().id(e).build()).collect(Collectors.toList());
            updateBook.setAuthors(alist);
        }
        Book updatedBook = this.bookRepo.save(updateBook);
        return updateBook;
    }

    @MutationMapping
    public Author createAuthor(@Argument String name , @Argument String email, @Argument String city , @Argument String state, @Argument String country){
        Author newAuthor = Author.builder().name(name).email(email).city(city).state(state).country(country).build();
        return this.authRepo.save(newAuthor);
    }

    @MutationMapping
    public Review createReview(@Argument Long book , @Argument String reviewer, @Argument Integer rating){
        Book bookToReview = Book.builder().id(book).build();
        Review review = Review.builder().reviewer(reviewer).rating(rating).book(bookToReview).build();
        return this.reviewRepo.save(review);
    }

}