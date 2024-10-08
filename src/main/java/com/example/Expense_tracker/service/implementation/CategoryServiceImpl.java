package com.example.Expense_tracker.service.implementation;

import com.example.Expense_tracker.mapper.CategoryMapper;
import com.example.Expense_tracker.dto.CategoryDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.repository.CategoryRepository;

import com.example.Expense_tracker.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category savedCategory = findCategoryById(categoryRepository, id); //default method
        return CategoryMapper.mapToDto(savedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
       List<Category> categories =  categoryRepository.findAll(); //default method
        return categories.stream().map(CategoryMapper::mapToDto).toList();
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = findCategoryById(categoryRepository, id);  //default method
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category =findCategoryById(categoryRepository, id);  //default method
        categoryRepository.delete(category);

    }
}
