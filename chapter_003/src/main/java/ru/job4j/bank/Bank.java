package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    Map<User, List<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> userListEntry : accounts.entrySet()) {
            if (userListEntry.getKey().getPassport().equals(passport)) {
                List<Account> accounts = userListEntry.getValue();
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> userListEntry : accounts.entrySet()) {
            if (userListEntry.getKey().getPassport().equals(passport)) {
                List<Account> accounts = userListEntry.getValue();
                accounts.remove(account);
                userListEntry.setValue(accounts);
            }
        }

    }
    public List<Account> getUserAccounts(String passport) {
        List<Account> tmp = new ArrayList<>();
        for (Map.Entry<User, List<Account>> userListEntry : accounts.entrySet()) {
            if (userListEntry.getKey().getPassport().equals(passport)) {
                tmp = userListEntry.getValue();
            }
        }
        return tmp;
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
        Account result = new Account();
        for (Map.Entry<User, List<Account>> userListEntry : accounts.entrySet()) {
            if (userListEntry.getKey().getPassport().equals(passport)) {
                List<Account> tmp = userListEntry.getValue();
                for (Account account : tmp) {
                    if (account.getRequisites().equals(requisite)) {
                        result = account;
                    }
                }
            }
        }
        return result;
    }
}
