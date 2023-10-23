package cashleh.transaction;

import cashleh.Ui;
import cashleh.exceptions.CashLehMissingTransactionException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Represents an Expense Statement in the CashLeh application.
 * This class is used to manage and store a list of expenses.
 * It provides methods for adding, deleting, retrieving, and displaying expenses within the statement.
 */
public class ExpenseStatement {

    private final ArrayList<Expense> expenseStatement = new ArrayList<>();

    public ExpenseStatement() {
    }

    public ExpenseStatement(Expense... expenses) {
        expenseStatement.addAll(List.of(expenses));
    }

    /**
     * Adds an expense to the statement.
     * @param expenseToAdd The expense to be added.
     */
    public void addExpense(Expense expenseToAdd) {
        expenseStatement.add(expenseToAdd);
    }

    /**
     * Deletes an expense from the statement.
     * @param expenseIndex The index of the expense to be deleted.
     * @throws CashLehMissingTransactionException If the specified expense is not found.
     */
    public void deleteExpense(int expenseIndex) throws CashLehMissingTransactionException {
        try {
            expenseStatement.remove(expenseIndex);
        } catch(IndexOutOfBoundsException e) {
            throw new CashLehMissingTransactionException();
        }
    }

    /**
     * Retrieve expense from the statement.
     * @param expenseIndex The index of the expense to be retrieved.
     * @return The expense at the specified index.
     * @throws CashLehMissingTransactionException If the specified expense is not found.
     */
    public Expense getExpense(int expenseIndex) throws CashLehMissingTransactionException {
        try {
            return expenseStatement.get(expenseIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new CashLehMissingTransactionException();
        }
    }

    public ArrayList<Expense> getExpenseStatement() {
        return this.expenseStatement;
    }
    
    public int getNumberOfExpenses() {
        return expenseStatement.size();
    }

    public double getTotalExpenseAmount() {
        return expenseStatement.stream().
                mapToDouble(Expense::getAmount).sum();
    }

    public void printExpenses() {
        int listSize = expenseStatement.size();
        String[] texts = new String[listSize + 1];
        texts[0] = "The current sum of all your expenses amounts to: " + getTotalExpenseAmount();
        for (int i = 1; i <= listSize; i++) {
            Expense currentExpense = expenseStatement.get(i - 1);
            texts[i] = "\t" + i + "." + currentExpense.toString();
        }
        Ui.printMultipleText(texts);
    }

    @Override
    public String toString() {
        return expenseStatement.stream().map(Expense::toString).collect(Collectors.joining("\n"));
    }
}
