package ru.job4j.bank;

import java.util.*;

public class Account {

    private double value;
    private String requisites;

    public Account() {
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    Map<User, List<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        accounts.putIfAbsent(user, null);
    }

    public void deleteUser(User user) {
        accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (accounts.containsKey(new User("name", passport))) {
            if (accounts.get(new User("name", passport)) != null) {
                List<Account> tmp = accounts.get(new User("name", passport));
                tmp.add(account);
                accounts.put(new User("name", passport), tmp);
            } else {
                List<Account> tmp = new ArrayList<>();
                tmp.add(account);
                accounts.put(new User("name", passport), tmp);
            }
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        if (accounts.containsKey(new User("name", passport))) {
            List<Account> tmp = accounts.get(new User("name", passport));
            tmp.remove(account);
            accounts.put(new User("name", passport), tmp);
        }
    }
    public List<Account> getUserAccounts(String passport) {
        List<Account> tmp = new ArrayList<>();
        if (accounts.containsKey(new User("name", passport))) {
            tmp = accounts.get(new User("name", passport));
        }
        return tmp;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        List<Account> tmp = accounts.get(new User("name", srcPassport));
        int index = tmp.indexOf(new Account(0, srcRequisite));
        double value = tmp.get(index).value;
        if (amount <= value) {
            value = value - amount;
            tmp.set(index, new Account(value, srcRequisite));
            accounts.put(new User("name", srcPassport), tmp);
            tmp = accounts.get(new User("name", destPassport));
            index = tmp.indexOf(new Account(0, destRequisite));
            value = tmp.get(index).value;
            value = value + amount;
            tmp.set(index, new Account(value, destRequisite));
            accounts.put(new User("name", destPassport), tmp);
            result = true;

        }
        return result;
    }



    @Override
    public String toString() {
        return "Account{"
                +
                "value=" + value
                +
                ", requisites=" + requisites
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
