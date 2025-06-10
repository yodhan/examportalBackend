package com.projects.examproject.service;

import com.projects.examproject.entity.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public void removeCategory(Long categoryId);
    public Set<Category> getCategories();
    public Category getCategory(Long categoryId);
}
