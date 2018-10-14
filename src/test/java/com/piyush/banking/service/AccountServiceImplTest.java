package com.piyush.banking.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.piyush.banking.dao.AccountRepository;
import com.piyush.banking.domain.Account;
import com.piyush.banking.exception.EntityNotFoundException;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

  @InjectMocks
  AccountServiceImpl accountServiceImpl;
  @Mock
  AccountRepository accountRepository;

  @Test
  public void accountDetailsTest() throws EntityNotFoundException {
    Long testAccountNumber = 1L;
    Account account = new Account();
    account.setAccountNumber(testAccountNumber);
    account.setBalance(5000);
    account.setName("Piyush");
    Optional<Account> repositryResponse = Optional.of(account);
    when(accountRepository.findById(testAccountNumber)).thenReturn(repositryResponse);
    Account actualresponse = accountServiceImpl.accountDetails(testAccountNumber);
    assertEquals("Account Name should be same", account.getName(), actualresponse.getName());
    assertEquals("Account number should be same", account.getAccountNumber(), actualresponse.getAccountNumber());
  }

  @Test(expected = EntityNotFoundException.class)
  public void accountDetailsTestException() throws EntityNotFoundException {
    Long testAccountNumber = 1L;
    Optional<Account> result = Optional.empty();
    when(accountRepository.findById(testAccountNumber)).thenReturn(result);
    accountServiceImpl.accountDetails(testAccountNumber);
  }

  @Test
  public void createAccountTest() {
    Account account = new Account();
    account.setBalance(5000);
    account.setName("Piyush");
    when(accountRepository.save(account)).thenReturn(account);
    Account actualresponse = accountServiceImpl.createAccount(account);
    assertEquals("Account Name should be same", account.getName(), actualresponse.getName());
  }

  @Test
  public void allAccountDetailsTest() {
    List<Account> expectedresponse = new ArrayList<Account>();
    when(accountRepository.findAll()).thenReturn(expectedresponse);
    List<Account> actualresponse = accountServiceImpl.allAccountDetails();
    assertEquals(expectedresponse, actualresponse);
  }
}
