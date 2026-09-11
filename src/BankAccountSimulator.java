public class BankAccountSimulator {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 1000.0);
        BankAccount account2 = new BankAccount("Jane Smith", 500.0);

        account1.deposit(200);
        account1.withdraw(100);
        account2.withdraw(500);
        account2.withdraw(200.0);

    }

}