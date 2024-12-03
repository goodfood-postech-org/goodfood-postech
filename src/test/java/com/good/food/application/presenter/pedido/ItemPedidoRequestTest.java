package com.good.food.application.presenter.pedido;

import com.good.food.domain.ItemPedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ItemPedidoRequestTest {

  @Test
  public void deveCriarPedidoRequestVazio() {
    ItemPedidoRequest itemPedidoRequest = new ItemPedidoRequest();

    assertNotNull(itemPedidoRequest);
  }

  @Test
  public void deveCriarPedidoRequest() {
    ItemPedidoRequest itemPedidoRequest = new ItemPedidoRequest("id", "obs", 5);

    assertNotNull(itemPedidoRequest);
    assertEquals(itemPedidoRequest.getObservacoes(), "obs");

    ItemPedido itemPedido = itemPedidoRequest.toDomain();
    assertNotNull(itemPedido);
    assertEquals(itemPedido.getObservacoes(), "obs");
  }
}
