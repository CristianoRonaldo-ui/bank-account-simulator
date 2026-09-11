# Bank Account Simulator

A command-lin Java program that simulates bank account operations using object-oriented programming. Each account is modeled as a `BankAccount` object with private fields and encapsulated behavior. Started as a first look at methods that mutate an object's state (`deposit`/`withdraw`), then extended with `transfer()` — a method where one object interacts with another object of the same class — and a transaction counter that tracks activity per account

## Features
- `BankAccount` class with private fields (`accountHolder`, `balance`, `transactionCount`) and public getters
- `deposit(double amount)`: increases the account balance, counts as a transaction
- `withdraw(double amount)`: decreases the balance only if there are sufficient funds; returns `boolean` to report success or failure; only counts as a transaction when it succeeds
- `transfer(BankAccount other, double amount)`: moves money from one account to another by reusing `withdraw()`/`deposit()` internally — so the same validation and transaction counting automatically apply to both accounts involved
- Tracks `transactionCount` per account (successful deposits, withdrawals, and both sides of a transfer)
- Manual PASS/FAIL tests covering a successful deposit, a rejected withdrawal, and a rejected transfer

## How to Run
```
javac src/*.java
java -cp src BankAccountSimulator
```

## Example Output
```
Deposited 200.0 to John Doe's account. New balance is 1200
Withdraw 100.0 from John Doe's account. New balance is 1100.0
Withdraw 500.0 from Jane Smith's account. New balance is 0.0
Insufficient funds for withdraw of 200.0 from Jane Smith's account. Current balance is 0.0

--- Transfer Demo ---
Withdraw 300.0 from John Doe's account. New balance is 800.0
Deposited 300.0 to Jane Smith's account. New balance is 300.0
Transferred 300.0 from John Doe to Jane Smith
John Doe's balance: 800.0
Jane Smith's balance: 300.0
John Doe's transaction count: 3
Jane Smith's transaction count: 2

-- Manual Test --
Deposited 50.0 to Test User's account. New balance is 150.0
Test 1 PASS: deposit adds correctly
Insufficient funds for withdraw of 1000.0 from Test User's account. Current balance is 150.0
Test 2 PASS: withdraw fails when insufficient funds
Insufficient funds for withdraw of 1000.0 from Sender's account. Current balance is 50.0
Test 3 PASS: transfer fails and receiver stays unchanged when sender has insufficient funds
```


## What I Learned
- Why fields should be `private`: without it, nothing stops outside code from setting `balance` to an invalid value directly. Routing every change through `deposit()`/`withdraw()` guarantees the same validation runs every time
- The difference between a method that only reads or calculates (like `getBalance()`) and one that mutates the object's actual state (`deposit()`/`withdraw()`)
- Using `if/else` not just to print different messages, but to decide whether a state change is allowed to happen at all.
- Reusing an already-validated method inside a new one instead of duplicating logic: `transfer()` calls `this.withdraw()` and `other.deposit()` rather than reimplementing the balance checks — which also means `transactionCount` stays correct on both accounts without any extra code.
- Placing a counter increment inside the success branch only (not the failure branch), so `transactionCount` reflects real transactions, not failed attempts