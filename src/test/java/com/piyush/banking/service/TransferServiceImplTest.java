package com.piyush.banking.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.piyush.banking.dao.AccountRepository;
import com.piyush.banking.domain.Account;
import com.piyush.banking.dto.TransferDTO;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.exception.InsufficientBalanceException;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TransferServiceImplTest {

  @InjectMocks
  TransferServiceImpl transferServiceImpl;

  @Mock
  AccountRepository accountRepository;

  @Test
  public void transferTest() throws EntityNotFoundException, InsufficientBalanceException {
    Long testAccountNumber = 1L;
    Account toAccount = new Account();
    toAccount.setAccountNumber(testAccountNumber);
    toAccount.setBalance(5000);
    toAccount.setName("Piyush");
    Account fromAccount = new Account();
    fromAccount.setAccountNumber(testAccountNumber);
    fromAccount.setBalance(2300);
    fromAccount.setName("Uygar");
    TransferDTO transferDTO = new TransferDTO();
    transferDTO.setAmount(123.0);
    transferDTO.setFromAccount(6L);
    transferDTO.setToAccount(1L);

    Optional<Account> fromAccountdetails = Optional.of(fromAccount);
    Optional<Account> toAccountdetails = Optional.of(toAccount);
    when(accountRepository.findById(transferDTO.getFromAccount())).thenReturn(fromAccountdetails);
    when(accountRepository.findById(transferDTO.getToAccount())).thenReturn(toAccountdetails);
    transferServiceImpl.transfer(transferDTO);

  }
}
