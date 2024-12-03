package com.good.food.driver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NotFoundExceptionTest {

  @Test
  public void deveNotFoundException() {
    assertThrows(NotFoundException.class, () -> { throw new NotFoundException(""); });
  }


  @Test
  public void deveNotFoundExceptionAgain() {
    assertThrows(NotFoundException.class, () -> { throw new NotFoundException("", new Exception()); });
  }
}
