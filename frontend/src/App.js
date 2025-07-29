import React from "react";
import ExpenseList from "./ExpenseList";

function App() {
    return (
        <div style={{ padding: "20px", fontFamily: "Arial" }}>
            <h1>Personal Finance Tracker</h1>
            <ExpenseList />
        </div>
    );
}

export default App;
