package com.projects.examproject.service.implementation;

import com.projects.examproject.entity.Category;
import com.projects.examproject.repository.CategoryRepository;
import com.projects.examproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>( this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }
}
