import java.util.HashMap;
import java.util.List;

public abstract class Expense {
    User fromUser;
    List<User> payToUsers;
    ExpenseStrategy expenseStrategy;
    Integer amountToSpend;
    List<Integer> distributionDetails;

    public abstract HashMap<String, Double> performExpense();

    public Expense(ExpenseStrategy expenseStrategy) {
        this.expenseStrategy = expenseStrategy;
    }

    public Expense setFromUser(User fromUser) {
        this.fromUser = fromUser;
        return this;
    }

    public Expense setPayToUsers(List<User> payToUsers) {
        this.payToUsers = payToUsers;
        return this;
    }

    public Expense setAmountToSpend(Integer amountToSpend) {
        this.amountToSpend = amountToSpend;
        return this;
    }

    public Expense setDistributionDetails(List<Integer> distributionDetails) {
        this.distributionDetails = distributionDetails;
        return this;
    }

    public Boolean validateAmount(){
        if (amountToSpend > 0) return true;
        System.out.println("Amount is not greater than 0");
        return false;
    }

}
