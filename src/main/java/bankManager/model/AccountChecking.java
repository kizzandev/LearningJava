package bankManager.model;

import java.math.BigInteger;

public class AccountChecking extends Account {

    public AccountChecking(String accountNumber, BigInteger initialBalance, Customer accountHolder) {
        super(accountNumber, initialBalance, accountHolder, AccountType.CHECKING);
    }
}
