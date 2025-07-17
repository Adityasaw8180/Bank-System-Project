package BankAccountBluePrint;

import ExceptionPackages.*;
// import ExceptionPackages.IncorrectPinNo;
// import ExceptionPackages.InvalidAmount;

public class BankBluePrint {
    private String accountNo;
    private int pin;
    private double totalMoney = 0;

    public BankBluePrint(String accountNo, int pin) {
        this.accountNo = accountNo;
        this.pin = pin;
        totalMoney = 0;
    }

    public void isAccountPinCorrect(String accountNo, int pin) throws AccountNotFound, IncorrectPinNo {
        if (!this.accountNo.equals(accountNo)) {
            throw new AccountNotFound("Account Not Found In Database");
        } else if (this.pin != pin) {
            throw new IncorrectPinNo("Please Enter Correct Pin Number");
        }

    }

    public void creditMoney(double amount) throws InvalidAmount {
        if (amount <= 0) {
            throw new InvalidAmount("Enter Proper Amount of Money");
        }
        totalMoney += amount;
    }

    public void debitMoney(double amount) throws InvalidAmount {
        if (amount <= 0) {
            throw new InvalidAmount("Enter Proper Amount of Money");
        } else if (amount > totalMoney) {
            throw new InvalidAmount("You Don't have Much Bank Balance");
        }
        totalMoney -= amount;
    }

    public String accountNo() {
        return accountNo;
    }

    public double bankBalance() {
        return totalMoney;
    }

}
