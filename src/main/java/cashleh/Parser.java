package cashleh;

import cashleh.commands.Command;

public class Parser {
    private static final String ADD_INCOME = "addIncome";
    private static final String DELETE_INCOME = "deleteIncome";
    private static final String VIEW_INCOMES = "viewIncomes";
    private static final String ADD_EXPENSE = "addExpense";
    private static final String DELETE_EXPENSE = "deleteExpense";
    private static final String VIEW_EXPENSES = "viewExpenses";
    private static final String EXIT = "exit";

    public Command parse(String input) {
        String command = input.contains(" ") ? input.split(" ")[0] : input;
        switch (command) {
        case ADD_INCOME:
            break;
        case DELETE_INCOME:
            break;
        case VIEW_INCOMES:
            break;
        case ADD_EXPENSE:
            break;
        case DELETE_EXPENSE:
            break;
        case VIEW_EXPENSES:
            break;
        case EXIT:
            break;
        default:

        }

    }
}