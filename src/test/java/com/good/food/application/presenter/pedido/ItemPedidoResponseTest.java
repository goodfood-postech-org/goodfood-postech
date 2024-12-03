package com.good.food.application.presenter.pedido;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ItemPedidoResponseTest {

  @Test
  public void deveCriarPedidoResponseVazio() {
    ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse();

    assertNotNull(itemPedidoResponse);
  }

  @Test
  public void deveCriarPedidoResponse() {
    ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse("id", "desc", "obs", 5, BigDecimal.TEN, "cat");

    assertNotNull(itemPedidoResponse);
    assertEquals(itemPedidoResponse.getObservacoes(), "obs");
  }
}
