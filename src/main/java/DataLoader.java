import org.example.model.Expense;
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
    expenseRepository.save(new Expense("Groceries", 120));
    expenseRepository.save(new Expense("Rent", 850));
    expenseRepository.save(new Expense("Internet", 60));
  }


}
