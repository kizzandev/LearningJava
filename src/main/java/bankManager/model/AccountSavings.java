package bankManager.model;

import java.math.BigInteger;

public class AccountSavings extends Account {

    public AccountSavings(String accountNumber, BigInteger initialBalance, Customer accountHolder) {
        super(accountNumber, initialBalance, accountHolder, AccountType.SAVINGS);
    }
}
