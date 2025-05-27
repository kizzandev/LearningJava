package bankManager.service;

import bankManager.model.Account;
import bankManager.model.Customer;

import java.math.BigInteger;
import java.util.*;
import java.security.SecureRandom;

public class BankService {

    private final Map<String, Customer> customers;
    private final Map<String, Account> accounts;

    public BankService() {
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    public Customer createCustomer(String name, String address, String phoneNumber) {
        Customer customer = new Customer(name, address, phoneNumber);
        while (customers.containsKey(customer.getCustomerId())) {
            customer.newId();
        }
        customers.put(customer.getCustomerId(), customer);
        return customer;
    }

    public Account createAccount(String accountNumber, String customerId, String type) {
        if (accounts.containsKey(accountNumber)) {
            return null;
        }

        Customer customer = customers.get(customerId);
        if (customer == null) {
            return null;
        }

        Account account = new Account(accountNumber, BigInteger.ZERO, customer, type);
        accounts.put(accountNumber, account);
        customer.addAccount(account);
        return account;
    }

    public Customer findCustomerById(String customerId) {
        return customers.get(customerId);
    }

    public Account findAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return false;
        }
        return account.deposit(amount);
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return false;
        }
        return account.withdraw(amount);
    }

    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        if (amount <= 0d) {
            return false;
        }

        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            return false;
        }
        if (fromAccount.equals(toAccount)) {
            return false;
        }

        if (fromAccount.getBalance() < amount) {
            return false;
        }

        boolean fromOk = fromAccount.withdraw(amount);
        if (!fromOk) {
            return false;
        }
        boolean toOk = toAccount.deposit(amount);
        if (!toOk) {
            fromAccount.deposit(amount);
            return false;
        }

        return true;
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public boolean bet(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return false;
        }

        // withdraw method checks this, but
        // better safe than sorry
        if (account.getBalance() < amount) {
            return false;
        }

        account.withdraw(amount);

        SecureRandom sr = new SecureRandom();
        double result = sr.nextDouble();
        System.out.println("Result: " + result);
        if (result > 0.1) {
            return false;
        }
        account.deposit(amount * 2);
        return true;
    }
}
