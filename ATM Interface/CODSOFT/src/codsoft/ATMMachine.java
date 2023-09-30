/**
 * 
 */
package codsoft;

import java.util.Scanner;

/**
 * 
 */
public class ATMMachine {

	/**
	 * @param args
	 */
	private BankAccount userAccount;

    public ATMMachine(BankAccount account) {
        userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Quit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Please select an option (1/2/3/4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Your balance is Rs." + userAccount.getBalance());
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: Rs.");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (userAccount.deposit(depositAmount)) {
                        System.out.println("Rs." + depositAmount + " deposited successfully.");
                    } else {
                        System.out.println("Invalid amount for deposit.");
                    }
                    break;
                case "3":
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Rs." + withdrawAmount + " withdrawn successfully.");
                    } else {
                        System.out.println("Invalid amount for withdrawal or insufficient balance.");
                    }
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
            }
        }
    }

}