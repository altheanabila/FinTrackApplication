import React, { useEffect, useState } from 'react';

function App() {
    const [expenses, setExpenses] = useState([]);
    const [form, setForm] = useState({ description: '', amount: '' });

    useEffect(() => {
        fetch('http://localhost:8080/api/expenses')
            .then(res => res.json())
            .then(data => setExpenses(data));
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();

        fetch('http://localhost:8080/api/expenses', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(form),
        })
            .then(res => res.json())
            .then(newExpense => {
                setExpenses([...expenses, newExpense]);
                setForm({ description: '', amount: '' }); // reset form
            });
    };

    return (
        <div style={{ padding: 20, fontFamily: 'Arial' }}>
            <h1>FinTrack</h1>

            <form onSubmit={handleSubmit} style={{ marginBottom: 20 }}>
                <input
                    type="text"
                    placeholder="Description"
                    value={form.description}
                    onChange={(e) => setForm({ ...form, description: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Amount"
                    value={form.amount}
                    onChange={(e) => setForm({ ...form, amount: e.target.value })}
                />
                <button type="submit">Add</button>
            </form>

            <ul>
                {expenses.map((exp) => (
                    <li key={exp.id}>
                        {exp.description} - ${exp.amount}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
