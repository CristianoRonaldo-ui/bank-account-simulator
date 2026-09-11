public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + " to " + accountHolder + "'s account. New balance is " + balance);

    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out
                    .println("Withdraw " + amount + " from " + accountHolder + "'s account. New balance is " + balance);
            return true;

        } else {
            System.out.println("Insufficient funds for withdraw of " + amount + " from " + accountHolder
                    + "'s account. Current balance is " + balance);

            return false;

        }
    }

    public boolean transfer(BankAccount other, double amount) {
        boolean success = this.withdraw(amount);
        if (success) {
            other.deposit(amount);
            System.out.println("Transferred " + amount + " from " + this.accountHolder + " to " + other.accountHolder);
        }
        return success;
    }

}