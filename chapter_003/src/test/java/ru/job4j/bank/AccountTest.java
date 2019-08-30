package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    @Test
    public void whenAddUser() {
        Account account = new Account();
        account.addUser(new User("Tom", "777"));
        account.addUser(new User("Kail", "888"));
        assertThat(2, is(account.accounts.size()));
    }

    @Test
    public void whenDeleteUser() {
        Account account = new Account();
        account.addUser(new User("Tom", "777"));
        account.addUser(new User("Kail", "888"));
        account.addUser(new User("Den", "999"));
        account.deleteUser(new User("Den", "999"));
        assertThat(2, is(account.accounts.size()));
    }

    @Test
    public void whenAddAccountToUser() {
        Account account = new Account();
        account.addUser(new User("Tom", "777"));
        account.addAccountToUser("777", new Account(30, "1234"));
        account.addAccountToUser("777", new Account(120, "2345"));
        List<Account> result = new ArrayList<>();
        result.add(new Account(30, "1234"));
        result.add(new Account(120, "2345"));
        assertThat(result, is(account.getUserAccounts("777")));
    }

    @Test
    public void whenDeleteAccountToUser() {
        Account account = new Account();
        account.addUser(new User("Tom", "777"));
        account.addAccountToUser("777", new Account(30, "1234"));
        account.addAccountToUser("777", new Account(120, "2345"));
        account.deleteAccountFromUser("777", new Account(120, "2345"));
        List<Account> result = new ArrayList<>();
        result.add(new Account(30, "1234"));
        assertThat(result, is(account.getUserAccounts("777")));
    }

    @Test
    public void whenTransferMoneyFromFirstUsersAccountToSecondUsersAccount() {
        Account account = new Account();
        account.addUser(new User("Tom", "777"));
        account.addAccountToUser("777", new Account(500, "1234"));
        account.addAccountToUser("777", new Account(100, "2345"));
        account.transferMoney("777", "1234", "777", "2345", 300);
        List<Account> result = new ArrayList<>();
        result.add(new Account(200, "1234"));
        result.add(new Account(100, "2345"));
        assertThat(result, is(account.getUserAccounts("777")));

    }



}
