package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;


public class Bank {

    Map<User, List<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        accounts.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .map(user -> accounts.get(user))
                .ifPresent(a -> a.add(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        accounts.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .map(user -> accounts.get(user))
                .ifPresent(a -> a.remove(account));

    }

    public List<Account> getUserAccounts(String passport) {
        return accounts.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> accounts.get(user))
                .findFirst()
                .orElse(new ArrayList<>());
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        double value;
        Account srcAccount = checkAccount(srcPassport, srcRequisite);
        Account destAccount = checkAccount(destPassport, destRequisite);
        if (!srcAccount.getRequisites().isEmpty()) {
            value = srcAccount.getValue();
            if (amount <= value) {
                value = value - amount;
                srcAccount.setValue(value);
                result = true;
            }
            if (result && !destAccount.getRequisites().isEmpty()) {
                value = destAccount.getValue();
                value = value + amount;
                destAccount.setValue(value);
            }
        }
        return result;
    }

    public Account checkAccount(String passport, String requisite) {
        return accounts.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> accounts.get(user))
                .findFirst()
                .flatMap(accounts -> accounts.stream()
                        .filter(account -> account.getRequisites().equals(requisite))
                        .findFirst())
                .orElse(null);

    }
}
