package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private double amount;

  public Expense() {}

  public Expense(String description, double amount) {
    this.description = description;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public double getAmount() {
    return amount;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
