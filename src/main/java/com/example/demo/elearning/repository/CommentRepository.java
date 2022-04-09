package com.example.demo.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.elearning.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
