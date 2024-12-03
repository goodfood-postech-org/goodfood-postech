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
    ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse(
            "id",
            "desc",
            "obs",
            5,
            BigDecimal.TEN,
            "cat");

    assertNotNull(itemPedidoResponse);

    assertEquals(itemPedidoResponse.getQuantidade(), 5);
    itemPedidoResponse.setQuantidade(1);
    assertEquals(itemPedidoResponse.getQuantidade(), 1);

    assertEquals(itemPedidoResponse.getPreco(), BigDecimal.TEN);
    itemPedidoResponse.setPreco(BigDecimal.ONE);
    assertEquals(itemPedidoResponse.getPreco(), BigDecimal.ONE);

    assertEquals(itemPedidoResponse.getDescricao(), "desc");
    itemPedidoResponse.setDescricao("desc2");
    assertEquals(itemPedidoResponse.getDescricao(), "desc2");

    assertEquals(itemPedidoResponse.getCategoria(), "cat");
    itemPedidoResponse.setCategoria("cat2");
    assertEquals(itemPedidoResponse.getCategoria(), "cat2");

    assertEquals(itemPedidoResponse.getObservacoes(), "obs");
    itemPedidoResponse.setObservacoes("obs2");
    assertEquals(itemPedidoResponse.getObservacoes(), "obs2");

    assertEquals(itemPedidoResponse.getId(), "id");
    itemPedidoResponse.setId("id2");
    assertEquals(itemPedidoResponse.getId(), "id2");
  }
}
