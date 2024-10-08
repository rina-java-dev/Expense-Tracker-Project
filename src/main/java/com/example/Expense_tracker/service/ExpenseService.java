package com.example.Expense_tracker.service;

import com.example.Expense_tracker.dto.ExpenseDto;

import com.example.Expense_tracker.entity.Expense;

import com.example.Expense_tracker.exception.ResourceNotFoundException;
import com.example.Expense_tracker.repository.ExpenseRepository;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long id);


    // Default method to check if an expense exists by ID
    default Expense findExpenseById(ExpenseRepository expenseRepository, Long id) {
        return expenseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense does not exist."));
    }
}
