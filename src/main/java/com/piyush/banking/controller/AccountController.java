package com.piyush.banking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.banking.domain.Account;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.service.AccountService;

/**
 * Controller class to perform account related tasks
 * 
 * @author Piyush Mittal
 * @created Oct 15, 2018
 */
@RestController
public class AccountController {

  @Autowired
  AccountService accountService;

  /**
   * Method to get account details of the customer
   * 
   * @param accountNumber the account number
   * @return the account details
   * @throws EntityNotFoundException the EntityNotFoundException
   */
  @RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET)
  public ResponseEntity<Account> accountDetails(@Valid @PathVariable Long accountNumber) throws EntityNotFoundException {
    return new ResponseEntity<Account>(accountService.accountDetails(accountNumber), HttpStatus.OK);
  }

  /**
   * Returns all the accounts details
   * 
   * @return the list of all the accounts
   */
  @RequestMapping(value = "/allaccounts", method = RequestMethod.GET)
  public ResponseEntity<List<Account>> allAccountDetails() {
    return new ResponseEntity<List<Account>>(accountService.allAccountDetails(), HttpStatus.OK);
  }

  /**
   * Method to add new account
   * 
   * @param accountDetails the new account details
   * @return the created account details
   */
  @RequestMapping(value = "/addaccount", method = RequestMethod.POST)
  public ResponseEntity<Account> createAccount(@Valid @RequestBody Account accountDetails) {
    return new ResponseEntity<Account>(accountService.createAccount(accountDetails), HttpStatus.CREATED);
  }

}
