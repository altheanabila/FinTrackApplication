package org.example.controller;

import org.example.entity.Expense;
import org.example.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {

  private final ExpenseRepository expenseRepository;

  public ExpenseController(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  @GetMapping
  public List<Expense> getAllExpenses() {
    return expenseRepository.findAll();
  }

  @PostMapping
  public Expense createExpense(@RequestBody Expense expense) {
    return expenseRepository.save(expense);
  }
}
