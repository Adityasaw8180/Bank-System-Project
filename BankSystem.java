import java.util.Scanner;
import java.util.Vector;

import SavedAccounts.*;
import BankAccountBluePrint.*;

//import ExceptionPackages.*;
class BankSystem {
    public static void main(String[] args) {
        int choice;
        String accountNo;
        int pinNo;
        BankBluePrint bank1 = null;
       Vector<BankBluePrint> bankList = new Vector<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\t---Welcome to Aditya's Bank Service---");
        while (true) {
            System.out.println(
                    "\n1. Create New Account\n2. Credit Money\n3. Debit Money\n4.Get Account No\n5.Get Total Amount\n6. Exit");
            System.out.print("\nEnter Your Option : ");
            choice = scan.nextInt();
            try {

                switch (choice) {
                    case 1:
                        System.out.println("Enter Your Account Number : ");
                        accountNo = scan.next();
                        System.out.println("Enter Your PIN Number : ");
                        pinNo = scan.nextInt();
                        System.out.println("Enter Amount to Deposite : ");
                        double amountDeposite = scan.nextDouble();
                        bank1 = new BankBluePrint(accountNo, pinNo);
                        bank1.creditMoney(amountDeposite);
                        savedAccount.saveAccounts(accountNo, pinNo, amountDeposite);
                        //bankList.add(bank1);                                      //new updated
                        System.out.println("\nAccount Created Successfully...\n");
                        break;
                    case 2:
                        if (bankList == null) {
                            System.out.println("No account exists. Please create an account first.");
                            break;
                        }

                        System.out.println("Enter Your Account Number : ");
                        accountNo = scan.next();
                        System.out.println("Enter Your PIN Number : ");
                        pinNo = scan.nextInt();
                        bank1.isAccountPinCorrect(accountNo, pinNo);
                        System.out.println("Enter Amount to Credit : ");
                        int creditMoney = scan.nextInt();
                        bank1.creditMoney(creditMoney);
                        savedAccount.saveAccounts(accountNo, pinNo, creditMoney);
                        System.out.println("Amount " + creditMoney + "rs Added Successfully To Your Account");
                        break;
                    case 3:
                        if (bank1 == null) {
                            System.out.println("No account exists. Please create an account first.");
                            break;
                        }

                        System.out.println("Enter Your Account Number : ");
                        accountNo = scan.next();
                        System.out.println("Enter Your PIN Number : ");
                        pinNo = scan.nextInt();
                        bank1.isAccountPinCorrect(accountNo, pinNo);
                        System.out.println("Enter Amount to Debit : ");
                        int debitMoney = scan.nextInt();
                        bank1.debitMoney(debitMoney);
                        savedAccount.saveAccounts(accountNo, pinNo, debitMoney);
                        System.out.println("Wait for A Transation");
                        Thread.sleep(3000); 
                        System.out.println("Collect Your Money");
                        Thread.sleep(2000);
                        System.out.println("Please Count Your CASH Before leaving Room");
                        Thread.sleep(3000);
                        break;
                    case 4:
                        if (bank1 == null) {
                            System.out.println("No account exists. Please create an account first.");
                            break;
                        }

                        // System.out.println("Get Account Number : ");
                        System.out.println(bank1.accountNo());
                        break;
                    case 5:
                        if (bank1 == null) {
                            System.out.println("\nNo account exists. Please create an account first.");
                            break;
                        }

                        // System.out.println("Get Total Amount : ");
                        System.out.println(bank1.bankBalance());
                        break;
                    case 6:
                        System.out.println("Exiting...\n");
                        scan.close();
                        return;

                    default:
                        System.out.println("Please Enter Valid Option...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            } finally {
                // implementation remaining
            }
        }

    }
}