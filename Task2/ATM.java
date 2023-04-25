package Task2;

import java.util.Scanner;

class BankAccount {

    Scanner sc = new Scanner(System.in);
    double balance = 50000.00;
    String transactionHistory = "";
    int transactions = 0;

    public boolean login() {

        // User login credentials

        int userid = 1234;
        int userPin = 4567;
        boolean isLogin = false;

        System.out.println("\n-------------------------\n");

        try {

            while (!isLogin) {

                System.out.print("Enter Your Userid :");
                int id = sc.nextInt();
                System.out.print("Enter Your Pin :");
                int pin = sc.nextInt();

                if (id == userid && pin == userPin) {
                    System.out.println("\nLogin Sucessfull");
                    isLogin = true;

                } else {
                    System.out.println("\nInvalid userid or Pin! Please try again.\n ");
                }
            }

        } catch (Exception e) {
            System.out.println("\nInvalid userid or Pin! Please try again.!");

        }
        return isLogin;
    }

    public void withdraw() {

        System.out.println("\nEnter amount to Withdraw");
        double withdrawAmount = sc.nextDouble();
        try {

            if (withdrawAmount > balance) {
                System.out.println("\nInsufficient balance! Please try again.");

            } else {
                transactions++;
                balance -= withdrawAmount;
                System.out.println("\nWithdrawal Successfully.Available balance: " + balance + "\n");
                String str = withdrawAmount + " Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str); // retrive the history

            }

        } catch (Exception e) {
            System.out.println("\nInvalid Number.Please try again!");

        }
    }

    public void deposit() {
        try {
            System.out.println("\nEnter your amount to deposit: ");
            double depositAmount = sc.nextDouble();

            transactions++;
            balance += depositAmount;
            System.out.println("\nDeposit Successfull. Available balance: " + balance + "\n");

            String str = depositAmount + " Rs Deposited\n";
            transactionHistory = transactionHistory.concat(str);

        } catch (Exception e) {
            System.out.println("\nInvalid Number! Please try again.");
        }

    }

    public void Transfer() {

        try {
            System.out.println("\nEnter recipient's account number: ");
            int accountNumber = sc.nextInt();

            System.out.println("Enter transfer amount");
            double transferAmount = sc.nextDouble();

            if (transferAmount > balance) {
                System.out.println("\nInsufficient balance! Please try again.\n");
            } else {
                transactions++;
                balance -= transferAmount;
                System.out.println("\nTransfer amount Successfull! Available balance: " + balance + "\n");
                String str = transferAmount + " Rs transfered to Account Number: " + accountNumber + "\n";
                transactionHistory = transactionHistory.concat(str);
            }

        } catch (Exception e) {
            System.out.println("\nInvalid Number! Please try again!");
        }

    }

    public void checkBalance() {

        System.out.println("\n" + "Available balance is Rs. " + balance);
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nNo transactions found!");
        } else {
            System.out.println("\nTranscations History:\n\n" + transactionHistory);
        }
    }

}
    
public class ATM {
    

    public static int UserChoice(int limit) {

        // User choice for login or Exit function
        int userInput = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                flag = true;

                if (flag && userInput > limit || userInput < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nEnter only integer value");
                flag = false;
            }
        }

        return userInput;
    }

    public static void main(String[] args) {

        BankAccount b = new BankAccount(); // Create instance of BankAccount

        while (true) {
            System.out.println("\n Welcome To ATM System\n-------------------------");
            System.out.println("\n   1.Login \n   2.Exit\n\n-------------------------\n");
            System.out.print("Enter Your Choice : ");
            int choice = UserChoice(2);

            if (choice == 1) {
                if (b.login()) {
                    boolean Quit = false;
                    while (!Quit) {
                        System.out.println(
                                "\n      ATM Menu\n-------------------------\n1.withdraw \n2.Deposit \n3.Transfer  \n4.check balance  \n5.Transaction History \n6.Quit \n-------------------------\n");
                        System.out.print("\nEnter Your Choice : ");
                        Scanner sc = new Scanner(System.in);
                        int options = sc.nextInt();

                        switch (options) {
                            case 1:
                                b.withdraw();
                                break;
                            case 2:
                                b.deposit();
                                break;
                            case 3:
                                b.Transfer();
                                break;
                            case 4:
                                b.checkBalance();
                                break;
                            case 5:
                                b.transHistory();
                                break;
                            case 6:
                                System.out.print("\n       *********\nThank You for using our ATM");
                                Quit = true;
                                // break;
                                System.exit(0);
                            default:
                                System.out.println("\nInvalid Choice.please try again.");
                        }
                    }

                }
            } else {
                System.exit(0);
            }
        }

    }
}
