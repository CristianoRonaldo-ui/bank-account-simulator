# Bank Account Simulator

A command-line Java program that simulates basic bank account operations using object-oriented programming. Each account is modeled as a `BankAccount` object with private fields and encapsulated behavior — the first project in this portfolio where calling a method actually changes the object's state over time, instead of just reading or calculating from it.

## Features
- `BankAccount` class with private fields (`accountHolder`, `balance`) and public getters
- `deposit(double amount)`: increases the account balance
- `withdraw(double amount)`: decreases the balance only if there are sufficient funds; returns `boolean` to report success or failure
- Multiple independent `BankAccount` objects tracked in a single program
- Manual PASS/FAIL tests covering both a successful deposit and a rejected withdrawal

## How to Run
```
javac src/*.java
java -cp src BankAccountSimulator
```

## Example Output
```
Deposited 200.0 to John Doe's account. New balance is 1200.0
Withdraw 100.0 from John Doe's account. New balance is 1100.0
Withdraw 500.0 from Jane Smith's account. New balance is 0.0
Insufficient funds for withdraw of 200.0 from Jane Smith's account. Current balance is 0.0

-- Manual Test --
Deposited 50.0 to Test User's account. New balance is 150.0
Test 1 PASS: deposit adds correctly
Insufficient funds for withdraw of 1000.0 from Test User's account. Current balance is 150.0
Test 2 PASS: withdraw fails when insufficient funds
```
## What I Learned
- Why fields should be `private`: without it, nothing stops outside code from setting `balance` to an invalid value directly. Routing every change through `deposit()`/`withdraw()` guarantees the same validation runs every time.
- The difference between a method that only reads or calculates (like `getBalance()`) and one that mutates the object's actual state (`deposit()`/`withdraw()`).
- Using `if/else` not just to print different messages, but to decide whether a state change is allowed to happen at all.



