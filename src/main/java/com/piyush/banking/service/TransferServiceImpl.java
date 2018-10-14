package com.piyush.banking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyush.banking.dao.AccountRepository;
import com.piyush.banking.domain.Account;
import com.piyush.banking.dto.TransferDTO;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.exception.InsufficientBalanceException;

@Service
public class TransferServiceImpl implements TransferService {

  @Autowired
  AccountRepository repository;

  @Override
  @Transactional
  public void transfer(TransferDTO transferDTO) throws EntityNotFoundException, InsufficientBalanceException {
    Optional<Account> fromAccountDetails = repository.findById(transferDTO.getFromAccount());
    if (fromAccountDetails.isPresent()) {
      synchronized (this) {
        Account fromAccount = fromAccountDetails.get();
        if (fromAccount.getBalance() >= transferDTO.getAmount()) {
          fromAccount.setBalance(fromAccount.getBalance() - transferDTO.getAmount());
          Optional<Account> toAccountDetails = repository.findById(transferDTO.getToAccount());
          if (toAccountDetails.isPresent()) {
            Account toAccount = toAccountDetails.get();
            toAccount.setBalance(toAccount.getBalance() + transferDTO.getAmount());
          } else {
            throw new EntityNotFoundException("Account number" + transferDTO.getToAccount() + " does not exists!");
          }
        } else {
          throw new InsufficientBalanceException("Account number" + transferDTO.getFromAccount()
              + " does not have sufficient balance!");
        }
      }

    } else {
      throw new EntityNotFoundException("Account number" + transferDTO.getFromAccount() + " does not exists!");
    }
  }
}
