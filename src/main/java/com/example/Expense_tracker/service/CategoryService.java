package com.example.Expense_tracker.service;

import com.example.Expense_tracker.dto.CategoryDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.exception.ResourceNotFoundException;
import com.example.Expense_tracker.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);


    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();


    CategoryDto updateCategory(Long id, CategoryDto categoryDto);


    void deleteCategory(Long id);


    // Default method to check if an account exists by ID
    default Category findCategoryById(CategoryRepository categoryRepository, Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist."));
    }
}
