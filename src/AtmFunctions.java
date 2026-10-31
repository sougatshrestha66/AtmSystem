import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String messg) {
        super(messg);
    }
}


class Account {


    private Scanner sc = new Scanner(System.in);
    private double totalBalance = 100000;
    private ArrayList<String> history = new ArrayList<>();


    public void checkBalance() {
        System.out.println("Your total balance is: " + totalBalance);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("There is no history yet.");
            return;
        }
        Iterator<String> iterator = history.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public void depositMethod() {
        double depositAmount = sc.nextDouble();

        if (depositAmount > 0) {
            totalBalance = totalBalance + depositAmount;
            System.out.println("Successfully deposited: " + depositAmount);
            System.out.println("Your new balance is: " + totalBalance);
            history.add("Deposited " + depositAmount);
        } else {
            throw new IllegalArgumentException("Please enter a positive amount");
        }
    }


    public void withdrawMethod() throws InsufficientBalanceException {
        double withdrawAmount = sc.nextDouble();
        if (withdrawAmount <= 0) {
            throw new IllegalArgumentException("Please enter the valid amount");
        }

        if (withdrawAmount > totalBalance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        totalBalance = totalBalance - withdrawAmount;
        System.out.println("Successfully Withdrawn: " + withdrawAmount);
        System.out.println("Your new balance is: " + totalBalance);
        history.add("Withdrawn " + withdrawAmount);
    }


    public void menu() {

        boolean running = true;

        while (running) {
            System.out.println("Welcome to our Atm service, Enter your option");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit Balance");
            System.out.println("3.Withdraw Balance");
            System.out.println("4. Show History");
            System.out.println("5.Exit");

            try {
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter your amount to deposit");

                        try {
                            depositMethod();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid amount");
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("Enter the amount you want to withdraw");
                        try {
                            withdrawMethod();
                        } catch (InsufficientBalanceException | IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid amount");
                            sc.nextLine();
                        }

                        break;
                    case 4:
                        showHistory();
                        break;
                    case 5:
                        System.out.println("Thankyou For choosing us");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid Option, Try Again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                sc.nextLine();
            }
        }
    }
}

class AtmFunctions {
    public static void main(String[] args) {
        Account a = new Account();
        a.menu();

    }
}



