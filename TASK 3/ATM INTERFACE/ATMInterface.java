import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("Enter the withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount > 0) {
                    if (bankAccount.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + bankAccount.getBalance());
                    }
                } else {
                    System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                }
                break;

            case 2:
                System.out.print("Enter the deposit amount: $");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                } else {
                    System.out.println("Invalid deposit amount. Please enter a positive value.");
                }
                break;

            case 3:
                System.out.println("Your current balance: $" + bankAccount.getBalance());
                break;

            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial balance of your bank account: $");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}
