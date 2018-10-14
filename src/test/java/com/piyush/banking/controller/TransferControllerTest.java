package com.piyush.banking.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.piyush.banking.dto.TransferDTO;
import com.piyush.banking.exception.EntityNotFoundException;
import com.piyush.banking.exception.InsufficientBalanceException;
import com.piyush.banking.service.TransferService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TransferControllerTest {


  @Mock
  TransferService transferService;
  @InjectMocks
  TransferController transferController;

  @Test
  public void transferTest() {

    TransferDTO transferDTO = new TransferDTO();
    transferDTO.setAmount(120);
    transferDTO.setFromAccount(2L);
    transferDTO.setToAccount(1L);
    ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Transaction Successfull", HttpStatus.OK);
    ResponseEntity<String> actualResponse = null;
    try {
      doNothing().when(transferService).transfer(transferDTO);
      actualResponse = transferController.transfer(transferDTO);
    } catch (EntityNotFoundException e) {
      fail("Exception should not be thrown");
    } catch (InsufficientBalanceException e) {
      fail("Exception should not be thrown");
    }

    assertEquals("Status Code Should be equal", expectedResponse.getStatusCode().value(), actualResponse
        .getStatusCode().value());
    assertEquals("ResponseEntity should be equal", expectedResponse, actualResponse);
  }

  @Test(expected = EntityNotFoundException.class)
  public void transferTestException() throws EntityNotFoundException, InsufficientBalanceException {

    TransferDTO transferDTO = new TransferDTO();
    transferDTO.setAmount(120);
    transferDTO.setFromAccount(2L);
    transferDTO.setToAccount(1L);
    doThrow(new EntityNotFoundException("Account number not found")).when(transferService).transfer(transferDTO);
    transferController.transfer(transferDTO);
  }

  @Test(expected = InsufficientBalanceException.class)
  public void transferTestInsufficientBalanceException() throws EntityNotFoundException, InsufficientBalanceException {

    TransferDTO transferDTO = new TransferDTO();
    transferDTO.setAmount(120);
    transferDTO.setFromAccount(2L);
    transferDTO.setToAccount(1L);
    doThrow(new InsufficientBalanceException("Insufficient account balance")).when(transferService).transfer(
        transferDTO);
    transferController.transfer(transferDTO);
  }

}
