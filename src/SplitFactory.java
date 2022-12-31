public class SplitFactory {

    public Expense getExpanseObject(ExpenseStrategy expenseStrategy){
        if (expenseStrategy == ExpenseStrategy.EQUAL){
            return new EqualExpense();
        } else if (expenseStrategy == ExpenseStrategy.EXACT){
            return new ExactExpense();
        } else if (expenseStrategy == ExpenseStrategy.PERCENTAGE) {
            return new PercentageExpense();
        }
        return null;
    }
}
