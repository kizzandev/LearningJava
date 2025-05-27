package bankManager.model;

import java.math.BigInteger;

public class Account {

    private final String accountNumber;
    private BigInteger balance;
    private final Customer accountHolder;
    private String accountType; // Savings

    public Account(String accountNumber, BigInteger initialBalance, Customer accountHolder, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        double dBalance = this.balance.doubleValue();
        dBalance /= 100d;
        return Math.round(dBalance * 100d) / 100d;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String type) {
        this.accountType = type;
    }

    public boolean deposit(BigInteger amount) {
        if (amount.intValue() <= 0) {
            return false;
        }

        this.balance = this.balance.add(amount);
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0d) {
            return false;
        }

        BigInteger bigInt = BigInteger.valueOf((int) (amount * 100d));

        this.balance = this.balance.add(bigInt);
        return true;
    }

    public boolean withdraw(BigInteger amount) {
        if (amount.doubleValue() <= 0) {
            return false;
        }
        if (this.balance.compareTo(amount) < 0) {
            return false;
        }

        this.balance = this.balance.subtract(amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0d) {
            return false;
        }
        if (this.getBalance() < amount) {
            return false;
        }

        BigInteger bigInt = BigInteger.valueOf((int) (amount * 100d));

        this.balance = this.balance.subtract(bigInt);
        return true;
    }

    @Override
    public String toString() {
        return "Account {\n" + "  accountNumber: " + this.accountNumber + ",\n" + "  balance: " + this.balance.doubleValue() + ",\n" + "  accountHolder: " + this.accountHolder.getCustomerId() + ",\n" + "  accountType: " + this.accountType + ",\n" + "}";
    }
}
