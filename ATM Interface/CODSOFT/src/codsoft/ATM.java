/**
 * 
 */
package codsoft;

/**
 * 
 */
public class ATM {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the bank account
        BankAccount userAccount = new BankAccount(initialBalance);
        ATMMachine atm = new ATMMachine(userAccount);
        atm.run();
    }
}
