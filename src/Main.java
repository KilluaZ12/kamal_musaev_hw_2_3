public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(20000.0);

        try {
            while (true) {
                account.withdraw(6000.0);
            }
        } catch (LimitException e) {
            double remainingAmount = e.getRemainingAmount();
            System.out.println("Remaining amount: " + remainingAmount);
            try {
                account.withdraw(remainingAmount);
            } catch (LimitException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Final balance: " + account.getAmount());
    }
}