package com.piyush.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.banking.dao.AccountRepository;
import com.piyush.banking.domain.Account;
import com.piyush.banking.exception.EntityNotFoundException;

/**
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountRepository repository;

  @Override
  public Account accountDetails(Long accountNumber) throws EntityNotFoundException {
    Optional<Account> result = repository.findById(accountNumber);
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new EntityNotFoundException("Account number" + accountNumber + " does not exists!");
    }
  }

  @Override
  public Account createAccount(Account accountDetails) {
    return repository.save(accountDetails);
  }

  @Override
  public List<Account> allAccountDetails() {
    return (List<Account>) repository.findAll();
  }

}
