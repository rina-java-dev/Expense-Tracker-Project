package com.example.Expense_tracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
			        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Expense Tracker API",
                description = "Expense Tracker API",
                version = "1.0.0"
        )
)
@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
