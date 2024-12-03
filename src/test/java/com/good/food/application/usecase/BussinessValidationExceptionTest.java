package com.good.food.application.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BussinessValidationExceptionTest {

  @Test
  public void deveNotFoundException() {
    assertThrows(BussinessValidationException.class, () -> { throw new BussinessValidationException(""); });
  }


  @Test
  public void deveNotFoundExceptionAgain() {
    assertThrows(BussinessValidationException.class, () -> { throw new BussinessValidationException("", new Exception()); });
  }
}
