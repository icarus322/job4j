package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Tom", "777"));
        bank.addUser(new User("Kail", "888"));
        assertThat(2, is(bank.accounts.size()));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Tom", "777"));
        bank.addUser(new User("Kail", "888"));
        bank.addUser(new User("Den", "999"));
        bank.deleteUser(new User("Den", "999"));
        assertThat(2, is(bank.accounts.size()));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Tom", "777"));
        bank.addAccountToUser("777", new Account(30, "1234"));
        bank.addAccountToUser("777", new Account(120, "2345"));
        List<Account> result = new ArrayList<>();
        result.add(new Account(30, "1234"));
        result.add(new Account(120, "2345"));
        assertThat(result, is(bank.getUserAccounts("777")));
    }

    @Test
    public void whenDeleteUsersAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("Tom", "777"));
        bank.addAccountToUser("777", new Account(30, "1234"));
        bank.addAccountToUser("777", new Account(120, "2345"));
        bank.deleteAccountFromUser("777", new Account(120, "2345"));
        List<Account> result = new ArrayList<>();
        result.add(new Account(30, "1234"));
        assertThat(result, is(bank.getUserAccounts("777")));
    }

    @Test
    public void whenTransferMoneyFromFirstUsersAccountToSecondUsersAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("Tom", "777"));
        bank.addAccountToUser("777", new Account(500, "1234"));
        bank.addAccountToUser("777", new Account(100, "2345"));
        bank.transferMoney("777", "1234", "777", "2345", 300);
        List<Account> result = new ArrayList<>();
        result.add(new Account(200, "1234"));
        result.add(new Account(400, "2345"));
        assertThat(result, is(bank.getUserAccounts("777")));

    }



}
