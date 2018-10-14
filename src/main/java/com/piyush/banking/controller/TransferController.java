package com.piyush.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.banking.dto.TransferDTO;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.exception.InsufficientBalanceException;
import com.piyush.banking.service.TransferService;

/**
 * Controller class to transfer money
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@RestController
public class TransferController {
  @Autowired
  TransferService transferService;

  /**
   * Method to transfer the money
   * 
   * @param transferDto the transferDto
   * @return the transaction status
   * @throws EntityNotFoundException the EntityNotFoundException
   * @throws InsufficientBalanceException the InsufficientBalanceException
   */
  @RequestMapping(value = "/transfer", method = RequestMethod.POST)
  public ResponseEntity<String> transfer(@Valid @RequestBody TransferDTO transferDto) throws EntityNotFoundException,
      InsufficientBalanceException {
    transferService.transfer(transferDto);
    return new ResponseEntity<String>("Transaction Successfull", HttpStatus.OK);
  }

}
