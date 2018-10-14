package com.piyush.banking.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DTO containing transfer details
 * 
 * @author Piyush Mittal piyush
 * @created Oct 15, 2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDTO {
  @NotNull(message = "Please provide debitor's account details")
  private Long fromAccount;
  @NotNull(message = "Please provide creditor's account details")
  private Long toAccount;
  @NotNull(message = "Please enter valid amount to be transfered")
  private double amount;

  /**
   * @return the fromAccount
   */
  public Long getFromAccount() {
    return fromAccount;
  }

  /**
   * @param fromAccount the fromAccount to set
   */
  public void setFromAccount(Long fromAccount) {
    this.fromAccount = fromAccount;
  }

  /**
   * @return the toAccount
   */
  public Long getToAccount() {
    return toAccount;
  }

  /**
   * @param toAccount the toAccount to set
   */
  public void setToAccount(Long toAccount) {
    this.toAccount = toAccount;
  }

  /**
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }


}
