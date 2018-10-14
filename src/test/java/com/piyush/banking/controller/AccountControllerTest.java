package com.piyush.banking.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.piyush.banking.domain.Account;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.service.AccountService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

  @InjectMocks
  AccountController accountController;
  @Mock
  AccountService accountService;

  @Test
  public void accountDetailsTest() {
    Long testaccountNumber = 2L;
    Account account = new Account();
    account.setAccountNumber(testaccountNumber);
    account.setBalance(5000);
    account.setName("Piyush");
    ResponseEntity<Account> expectedResponse = new ResponseEntity<Account>(account, HttpStatus.OK);
    ResponseEntity<Account> actualResponse = null;
    try {
      when(accountService.accountDetails(testaccountNumber)).thenReturn(account);
      actualResponse = accountController.accountDetails(testaccountNumber);
    } catch (EntityNotFoundException e) {
      fail("no Exception should be thrown");
    }
    assertEquals("Status Code Should be equal", expectedResponse.getStatusCode().value(), actualResponse
        .getStatusCode().value());
    assertEquals("ResponseEntity should be equal", expectedResponse, actualResponse);
    assertEquals("Account Name should be equal", expectedResponse.getBody().getName(), actualResponse.getBody()
        .getName());
  }

  @Test(expected = EntityNotFoundException.class)
  public void accountDetailsTestException() throws EntityNotFoundException {
    Long testaccountNumber = 2L;
    when(accountService.accountDetails(testaccountNumber)).thenThrow(
        new EntityNotFoundException("Account does not exisit"));
    accountController.accountDetails(testaccountNumber);
  }

  @Test
  public void allAccountTest() {
    List<Account> accountList = new ArrayList<Account>();
    ResponseEntity<List<Account>> expectedResponse = new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    when(accountService.allAccountDetails()).thenReturn(accountList);
    ResponseEntity<List<Account>> actualResponse = accountController.allAccountDetails();
    assertEquals("Status Code Should be equal", expectedResponse.getStatusCode().value(), actualResponse
        .getStatusCode().value());
    assertEquals("ResponseEntity should be equal", expectedResponse, actualResponse);
  }

  @Test
  public void createAccountTest() {
    Account account = new Account();
    account.setBalance(5000);
    account.setName("Piyush");
    ResponseEntity<Account> expectedResponse = new ResponseEntity<Account>(account, HttpStatus.OK);
    ResponseEntity<Account> actualResponse = null;
    when(accountService.createAccount(account)).thenReturn(account);
    actualResponse = accountController.createAccount(account);
    assertEquals("Status Code Should be equal", expectedResponse.getStatusCode().value(), actualResponse
        .getStatusCode().value());
    assertEquals("ResponseEntity should be equal", expectedResponse, actualResponse);
    assertEquals("Account Name should be equal", expectedResponse.getBody().getName(), actualResponse.getBody()
        .getName());
  }
}
