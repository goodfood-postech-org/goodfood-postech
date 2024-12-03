package com.good.food.application.presenter.pedido;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoResponseTest {

  @Test
  public void deveCriarPedidoResponseVazio() {
    PedidoResponse pedidoResponse = new PedidoResponse();

    assertNotNull(pedidoResponse);
  }

  @Test
  public void deveCriarPedidoResponse() {
    PedidoResponse pedidoResponse = new PedidoResponse(
            "id",
            "cpf",
            "nome",
            new ArrayList<>(),
            LocalDate.now(),
            LocalDate.now(),
            "status",
            "statusPagamento",
            "qrData");

    assertNotNull(pedidoResponse);
    assertEquals(pedidoResponse.getCpf(), "123");
  }
}
