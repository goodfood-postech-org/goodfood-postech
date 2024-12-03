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
    pedidoResponse.setCpf("321");
    assertEquals(pedidoResponse.getCpf(), "321");

    assertEquals(pedidoResponse.getId(), "id");
    pedidoResponse.setId("id2");
    assertEquals(pedidoResponse.getId(), "id2");

    assertEquals(pedidoResponse.getNome(), "nome");
    pedidoResponse.setNome("nome2");
    assertEquals(pedidoResponse.getNome(), "nome2");

    assertEquals(pedidoResponse.getStatus(), "status");
    pedidoResponse.setStatus("status2");
    assertEquals(pedidoResponse.getStatus(), "status2");

    assertEquals(pedidoResponse.getStatusPagamento(), "statusPagamento");
    pedidoResponse.setStatusPagamento("statusPagamento2");
    assertEquals(pedidoResponse.getStatusPagamento(), "statusPagamento2");

    assertEquals(pedidoResponse.getQrData(), "qrData");
    pedidoResponse.setQrData("qrData2");
    assertEquals(pedidoResponse.getQrData(), "qrData2");

    assertEquals(pedidoResponse.getDataAtualizacao(), LocalDate.now());
    pedidoResponse.setDataAtualizacao(LocalDate.now().plusDays(1));
    assertEquals(pedidoResponse.getDataAtualizacao(), LocalDate.now().plusDays(1));

    assertEquals(pedidoResponse.getDataCriacao(), LocalDate.now());
    pedidoResponse.setDataCriacao(LocalDate.now().plusDays(1));
    assertEquals(pedidoResponse.getDataCriacao(), LocalDate.now().plusDays(1));

  }
}
