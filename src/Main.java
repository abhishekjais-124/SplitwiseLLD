import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        User user1 = new User("abc", "ABC");
        User user2 = new User("bcd","BCD");
        User user3 = new User("cde", "CDE");
        User user4 = new User("def","DEF");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);

        BalanceSheet balanceSheet = new BalanceSheet(userController);
        ExpenseController expenseController = new ExpenseController(balanceSheet);

        expenseController.createExpense(user1, List.of(user2, user3), ExpenseStrategy.EQUAL, 1000, null);

        balanceSheet.printBalanceSheet();

        System.out.println("----------------------------------");

        expenseController.createExpense(user2, List.of(user1, user4), ExpenseStrategy.EXACT, 1000, List.of(600, 400));

        balanceSheet.printBalanceSheet();

        System.out.println("----------------------------------");

        expenseController.createExpense(user3, List.of(user1, user2, user3, user4), ExpenseStrategy.PERCENTAGE, 1000, List.of(25,25,30,20));

        balanceSheet.printBalanceSheet();

        System.out.println("----------------------------------");

        expenseController.createExpense(user3, List.of(user1, user2, user3, user4), ExpenseStrategy.PERCENTAGE, 1000, List.of(25,25,30,10));

        System.out.println("----------------------------------");


    }
}