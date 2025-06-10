package com.projects.examproject.repository;

import com.projects.examproject.entity.Category;
import com.projects.examproject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory_cid(Long category);
    public  List<Quiz> findByActive(Boolean active);
    public List<Quiz> findByCategory_cidAndActive(Long category, Boolean active);
}