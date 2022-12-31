import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    HashMap<String, HashMap<String,Double>> balanceSheet;
    UserController userController;

    public BalanceSheet(UserController userController) {
        balanceSheet = new HashMap<>();
        this.userController = userController;
    }

    public void printBalanceSheetByUser(User user){
        if (!balanceSheet.containsKey(user.getUserId())){
            return;
        }
        System.out.println("Balance sheet of "+ user.getUserName());
        HashMap<String,Double> expenseMap = balanceSheet.get(user.getUserId());
        for (Map.Entry<String,Double> exMap : expenseMap.entrySet()) {
            String userId = exMap.getKey();
            Double amount = exMap.getValue();
            if (amount < 0) System.out.println(user.getUserId() + " has to pay " + -amount + " to " + userId);
            if (amount > 0) System.out.println(user.getUserId() + " has to recieve " + amount + " from " + userId);
        }
    }

    public void printBalanceSheet(){
        if (balanceSheet.isEmpty()){
            System.out.println("No data present");
            return;
        }
        for (User user: userController.usersList) printBalanceSheetByUser(user);

    }

    public void updateBalanceSheet(User fromUser, HashMap<String,Double> expenseMap){
        if (! balanceSheet.containsKey(fromUser.getUserId()))   balanceSheet.put(fromUser.getUserId(), new HashMap<String, Double>());
        for (Map.Entry<String,Double> exMap : expenseMap.entrySet()) {
            String userId = exMap.getKey();
            Double amount = exMap.getValue();
            if (userId != fromUser.userId) {
                if (!balanceSheet.containsKey(userId)) balanceSheet.put(userId, new HashMap<String, Double>());
                balanceSheet.get(fromUser.getUserId()).put(userId, amount + balanceSheet.get(fromUser.getUserId()).getOrDefault(userId, 0.0));
                balanceSheet.get(userId).put(fromUser.getUserId(), balanceSheet.get(userId).getOrDefault(fromUser.getUserId(), 0.0) - amount);
            }
        }
    }
}
