package com.projects.examproject.repository;

import com.projects.examproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
