import java.util.HashMap;

public class PercentageExpense extends Expense{
    public PercentageExpense() {
        super(ExpenseStrategy.PERCENTAGE);
    }

    public HashMap<String, Double> performExpense(){
        if (!validateAmount() || !validateDistribution()) return null;
        HashMap<String,Double> expenseMap = new HashMap<>();
        int index = 0;
        for (User user: payToUsers){
            expenseMap.put(user.userId, (amountToSpend*Double.valueOf(distributionDetails.get(index)))/100);
            index+=1;
        }
        return expenseMap;
    }

    private boolean validateDistribution() {
        if (distributionDetails.size() != payToUsers.size()) return false;
        int total = 0;
        for(int val: distributionDetails) total += val;
        if (total != 100) return false;
        return true;
    }
}
