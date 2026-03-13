import java.util.Scanner;

class ATM {
    private double balance = 10000; // initial balance
    private int pin = 9182;

    public void checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your ATM PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println(" Incorrect PIN. Try again.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println(" Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println(" Amount deposited successfully.");
        } else {
            System.out.println(" Invalid amount.");
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println(" Invalid amount.");
        } else {
            balance -= amount;
            System.out.println(" Please collect your cash.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}