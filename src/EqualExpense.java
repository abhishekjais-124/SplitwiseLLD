import java.util.HashMap;

public class EqualExpense extends Expense{
    public EqualExpense() {
        super(ExpenseStrategy.EQUAL);
    }

    public HashMap<String, Double> performExpense(){
        if (!validateAmount()) return null;
        HashMap<String,Double> expenseMap = new HashMap<>();
        Double amountForEach = Double.valueOf(amountToSpend) / Double.valueOf(payToUsers.size());
        for (User user: payToUsers){
            expenseMap.put(user.userId, amountForEach);
        }
        return expenseMap;
    }
}
