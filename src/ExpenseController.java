import java.util.HashMap;
import java.util.List;

public class ExpenseController {
    BalanceSheet balanceSheet;
    SplitFactory splitFactory;

    public ExpenseController(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
        this.splitFactory = new SplitFactory();
    }

    public void createExpense(User fromUser, List<User> payToUsers, ExpenseStrategy expenseStrategy, Integer amountToSpend, List<Integer> details){
        Expense expense = splitFactory.getExpanseObject(expenseStrategy);
        expense.setFromUser(fromUser).setPayToUsers(payToUsers).setAmountToSpend(amountToSpend).setDistributionDetails(details);
        HashMap<String,Double> expenseMap = expense.performExpense();
        if (expenseMap == null){
            System.out.println("Invalid expense");
            return;
        }
        balanceSheet.updateBalanceSheet(fromUser, expenseMap);

    }
}
