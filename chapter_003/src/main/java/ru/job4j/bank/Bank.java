package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

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
        if (checkAccount(srcPassport, srcRequisite) && checkAccount(destPassport, destRequisite)){
            List<Account> tmp = accounts.get(new User("name", srcPassport));
            int index = tmp.indexOf(new Account(0, srcRequisite));
            double value = tmp.get(index).getValue();
            if (amount <= value) {
                value = value - amount;
                tmp.set(index, new Account(value, srcRequisite));
                accounts.put(new User("name", srcPassport), tmp);
                tmp = accounts.get(new User("name", destPassport));
                index = tmp.indexOf(new Account(0, destRequisite));
                value = tmp.get(index).getValue();
                value = value + amount;
                tmp.set(index, new Account(value, destRequisite));
                accounts.put(new User("name", destPassport), tmp);
                result = true;

            }
        }

        return result;
    }
    public boolean checkAccount(String passport, String requisite) {
        boolean result = false;
        if (accounts.containsKey(new User("name", passport))){
            result = true;
        }
        return result;
    }
}
