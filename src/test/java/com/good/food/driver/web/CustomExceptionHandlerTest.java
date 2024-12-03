package com.good.food.driver.web;

import com.good.food.application.usecase.BussinessValidationException;
import com.good.food.driver.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CustomExceptionHandlerTest {

  @InjectMocks
  public CustomExceptionHandler provider;

  @Test
  public void deveHandleNotFoundException() {
    HttpEntity<Object> httpEntity = provider.handleNotFoundException(new NotFoundException("Error test"));

    assertNotNull(httpEntity.getHeaders());
  }

  @Test
  public void deveHandleIllegalArgumentException() {
    HttpEntity<Object> httpEntity = provider.handleIllegalArgumentException(new IllegalArgumentException("Error test"));

    assertNotNull(httpEntity.getHeaders());
  }

  @Test
  public void deveHandleBussinessValidationException() {
    HttpEntity<Object> httpEntity = provider.handleIllegalArgumentException(new BussinessValidationException("Error test"));

    assertNotNull(httpEntity.getHeaders());
  }
}
