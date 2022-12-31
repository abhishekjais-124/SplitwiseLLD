import java.util.HashMap;

public class ExactExpense extends Expense{

    public ExactExpense() {
        super(ExpenseStrategy.EXACT);
    }

    public HashMap<String, Double> performExpense(){
        if (!validateAmount() || !validateDistribution()) return null;
        HashMap<String,Double> expenseMap = new HashMap<>();
        int index = 0;
        for (User user: payToUsers){
            expenseMap.put(user.userId, Double.valueOf(distributionDetails.get(index)));
            index+=1;
        }
        return expenseMap;
    }

    private boolean validateDistribution() {
        if (distributionDetails.size() != payToUsers.size()) return false;
        int total = 0;
        for(int val: distributionDetails) total += val;
        if (total != amountToSpend) return false;
        return true;
    }
}
