import React, { useEffect, useState } from "react";

const ExpenseList = () => {
    const [expenses, setExpenses] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/expenses")
            .then((res) => res.json())
            .then((data) => setExpenses(data))
            .catch((err) => console.error("Error fetching data:", err));
    }, []);

    return (
        <div>
            <h2>Expense List</h2>
            <table border="1" cellPadding="10">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Amount ($)</th>
                </tr>
                </thead>
                <tbody>
                {expenses.map((expense) => (
                    <tr key={expense.id}>
                        <td>{expense.id}</td>
                        <td>{expense.description}</td>
                        <td>{expense.amount}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ExpenseList;
