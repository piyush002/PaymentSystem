package com.piyush.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for no account details
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -7963038885984776258L;

  public EntityNotFoundException(String message) {
    super(message);
  }

}
