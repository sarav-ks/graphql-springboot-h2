package com.example.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookreview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, String> {

}