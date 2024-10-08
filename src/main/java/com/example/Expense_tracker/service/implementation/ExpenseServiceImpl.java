package com.example.Expense_tracker.service.implementation;

import com.example.Expense_tracker.dto.ExpenseDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.entity.Expense;
import com.example.Expense_tracker.mapper.ExpenseMapper;
import com.example.Expense_tracker.repository.CategoryRepository;
import com.example.Expense_tracker.repository.ExpenseRepository;
import com.example.Expense_tracker.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;


    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToEntity(expenseDto);
        Expense savedExpense = ExpenseMapper.mapToEntity(expenseDto);
        return ExpenseMapper.mapToDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense savedExpense = findExpenseById(expenseRepository, id);
        return ExpenseMapper.mapToDto(savedExpense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::mapToDto).toList();
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = findExpenseById(expenseRepository, id);
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        if (expenseDto.category() != null) {
            Category category = categoryRepository.findById(expenseDto.category().id())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            expense.setCategory(category);
        }
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = findExpenseById(expenseRepository, id);
        expenseRepository.delete(expense);

    }
}
