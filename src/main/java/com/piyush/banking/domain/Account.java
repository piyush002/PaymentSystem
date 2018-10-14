package com.piyush.banking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Domain Object for account Table
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@JsonSerialize
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long accountNumber;

  @Column(nullable = false)
  @NotNull(message = "Please provide account holder name")
  private String name;
  @Column(nullable = false)
  private double balance;

  /**
   * @return the accountNumber
   */
  public Long getAccountNumber() {
    return accountNumber;
  }

  /**
   * @param accountNumber the accountNumber to set
   */
  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * @param balance the balance to set
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }



}
