package org.example;

import org.example.entity.Expense;
import org.example.repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final ExpenseRepository expenseRepository;

  public DataLoader(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  @Override
  public void run(String... args) {
    expenseRepository.save(new Expense("Coffee", 5.0));
    expenseRepository.save(new Expense("Groceries", 40.0));
  }


}
