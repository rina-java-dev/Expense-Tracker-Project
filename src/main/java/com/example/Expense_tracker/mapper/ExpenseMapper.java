package com.example.Expense_tracker.mapper;

import com.example.Expense_tracker.dto.CategoryDto;
import com.example.Expense_tracker.dto.ExpenseDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.entity.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToDto(Expense expense) {
        return new ExpenseDto(
                expense.getExpenseId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(expense.getCategory().getId(),
                        expense.getCategory().getName())
        );
    }


    public static Expense mapToEntity(ExpenseDto expenseDto) {
       Category category = new Category();
       category.setId(expenseDto.category().id());

       return new  Expense(expenseDto.id(),
               expenseDto.amount(),
               expenseDto.expenseDate(),
               category);

    }
}
