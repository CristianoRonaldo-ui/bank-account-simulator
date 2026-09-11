public class BankAccountSimulator {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 1000.0);
        BankAccount account2 = new BankAccount("Jane Smith", 500.0);

        account1.deposit(200);
        account1.withdraw(100);
        account2.withdraw(500);
        account2.withdraw(200.0);

        System.out.println("\n -- Manual Test -- ");

        BankAccount testAccount = new BankAccount("Test User", 100.0);
        testAccount.deposit(50.0);

        if (testAccount.getBalance() == 150.0) {
            System.out.println("Test 1 PASS: deposit adds correctly");
        } else {
            System.out.println("Test 1 FAIL: expected 150.0 but got " + testAccount.getBalance());
        }

        boolean result = testAccount.withdraw(1000.0);
        if (result == false) {
            System.out.println("Test 2 PASS: withdraw fails when insufficient funds");
        } else {
            System.out.println("Test 2 FAIL: expected false but got true");
        }
    }

}