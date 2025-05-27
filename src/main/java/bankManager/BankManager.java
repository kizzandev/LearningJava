package bankManager;

import bankManager.model.Account;
import bankManager.model.Customer;
import bankManager.service.BankService;

import java.util.Scanner;

public class BankManager {

    private static final BankService bankService = new BankService();
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Bank Manager!");

        LOOP:
        do {
            System.out.println("""
                    0. exit
                    1. create customer
                    2. create account
                    3. deposit
                    4. withdraw
                    5. transfer
                    6. show customers
                    7. show accounts
                    8. bet""");
            int opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 0: {
                    break LOOP;
                }
                case 1: {
                    System.out.println("New customer.");
                    System.out.print("Name: ");
                    String name = read.nextLine();
                    System.out.print("Address: ");
                    String address = read.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = read.nextLine();
                    Customer createdCustomer = bankService.createCustomer(name, address, phoneNumber);
                    System.out.println("Customer Id: " + createdCustomer.getCustomerId());
                    break;
                }
                case 2: {
                    System.out.println("New account.");
                    System.out.print("Account Number: ");
                    String accountNumber = read.nextLine();
                    System.out.print("Customer Id: ");
                    String customerId = read.nextLine();
                    System.out.print("Type: ");
                    String type = read.nextLine();
                    bankService.createAccount(accountNumber, customerId, type);
                    break;
                }
                case 3: {
                    System.out.print("Account Number: ");
                    String toDepositAccount = read.nextLine();
                    System.out.print("Deposit: ");
                    double toDeposit = Double.parseDouble(read.nextLine());
                    bankService.deposit(toDepositAccount, toDeposit);
                    break;
                }
                case 4: {
                    System.out.print("Account Number: ");
                    String toWithdrawAccount = read.nextLine();
                    System.out.print("Withdraw: ");
                    double toWithdraw = Double.parseDouble(read.nextLine());
                    bankService.withdraw(toWithdrawAccount, toWithdraw);
                    break;
                }
                case 5: {
                    System.out.print("Transfer From Account Number: ");
                    String transferFromAccount = read.nextLine();
                    System.out.print("Transfer To Account Number: ");
                    String transferToAccount = read.nextLine();
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(read.nextLine());
                    bankService.transferFunds(transferFromAccount, transferToAccount, amount);
                    break;
                }
                case 6: {
                    for (Customer customer : bankService.getAllCustomers()) {
                        System.out.println(customer);
                        for (Account account : customer.getAccounts()) {
                            System.out.println("  - " + account.getAccountNumber() + " (" + account.getAccountType() + "): $" + account.getBalance());
                        }
                    }
                    break;
                }
                case 7: {
                    for (Account account : bankService.getAllAccounts()) {
                        System.out.println(account);
                    }
                    break;
                }
                case 8: {
                    System.out.print("Account: ");
                    String betWithAccount = read.nextLine();
                    System.out.print("Amount: ");
                    double amountToBet = Double.parseDouble(read.nextLine());

                    boolean betSuccess = bankService.bet(betWithAccount, amountToBet);
                    if (betSuccess) {
                        System.out.println("You won!");
                    }
                    System.out.println("New balance: " + bankService.findAccountByNumber(betWithAccount).getBalance());
                    break;
                }
            }
        } while (true);

        read.close();
        System.out.println("\nThank you for choosing us!");
    }
}
