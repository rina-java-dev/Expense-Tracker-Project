package com.example.Expense_tracker.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;


import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Expense {


   @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long expenseId;

   @Column(nullable = false)
   private BigDecimal amount;

    @Column(nullable = false)
   private LocalDate expenseDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) //foreign key in the expense table
   private Category category;
}
