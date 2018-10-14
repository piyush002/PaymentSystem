package com.piyush.banking.service;

import com.piyush.banking.dto.TransferDTO;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.exception.InsufficientBalanceException;

public interface TransferService {

  /**
   * Transfer the amount to another account
   * 
   * @param transferDto the transfer DTO
   * @throws EntityNotFoundException the EntityNotFoundException
   * @throws InsufficientBalanceException the InsufficientBalanceException
   */
  public void transfer(TransferDTO transferDto) throws EntityNotFoundException, InsufficientBalanceException;

}
