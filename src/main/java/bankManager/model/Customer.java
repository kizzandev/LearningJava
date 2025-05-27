package bankManager.model;

import java.util.ArrayList;
import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String name;
    private String address;
    private String phoneNumber;
    private final ArrayList<Account> accounts;

    public Customer(String name, String address, String phoneNumber) {
        this.customerId = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId.toString();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Account> getAccounts() {
        // Copy of
        return new ArrayList<>(accounts);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void newId() {
        this.customerId = UUID.randomUUID();
    }

    public void addAccount(Account account) {
        if (account != null && !accounts.contains(account)) {
            this.accounts.add(account);
        }
    }

    public void removeAccount(Account account) {
        if (account != null) {
            this.accounts.remove(account);
        }
    }

    @Override
    public String toString() {
        return "Customer {\n" +
               "  customerId: " + this.customerId.toString() + ",\n" +
               "  name: " + this.name + ",\n" +
               "  address: " + this.address + ",\n" +
               "  phoneNumber: " + this.phoneNumber + ",\n" +
               "  totalAccounts: " + this.accounts.size() + "\n" +
               "}";
    }
}
