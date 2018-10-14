package com.piyush.banking.service;

import java.util.List;

import com.piyush.banking.domain.Account;
import com.piyush.banking.exception.EntityNotFoundException;


public interface AccountService {

  /**
   * returns the account details of a user
   * 
   * @param accountNumber the account number
   * @return the account object
   * @throws EntityNotFoundException the EntityNotFoundException
   */
  public Account accountDetails(Long accountNumber) throws EntityNotFoundException;

  /**
   * returns all the accounts details
   * 
   * @return the list of accounts
   */
  public List<Account> allAccountDetails();

  /**
   * Creates a new account
   * 
   * @param accountDetails the account details
   * @return the created account details
   */
  public Account createAccount(Account accountDetails);
}
