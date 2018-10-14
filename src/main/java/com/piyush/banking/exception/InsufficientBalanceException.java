package com.piyush.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for insufficient Balance
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The account is having insufficient balance")
public class InsufficientBalanceException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7415871921247242688L;

  public InsufficientBalanceException(String message) {
    super(message);
  }
}
