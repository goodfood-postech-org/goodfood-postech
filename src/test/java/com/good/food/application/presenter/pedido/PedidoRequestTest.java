package com.good.food.application.presenter.pedido;

import com.good.food.domain.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoRequestTest {

  @Test
  public void deveCriarPedidoRequestVazio() {
    PedidoRequest pedidoRequest = new PedidoRequest();

    assertNotNull(pedidoRequest);
  }

  @Test
  public void deveCriarPedidoRequest() {
    PedidoRequest pedidoRequest = new PedidoRequest("123", "nome", new ArrayList<>());

    assertNotNull(pedidoRequest);

    assertEquals(pedidoRequest.getClienteCPF(), "123");
    pedidoRequest.setClienteCPF("321");
    assertEquals(pedidoRequest.getClienteCPF(), "321");

    assertEquals(pedidoRequest.getClienteNome(), "nome");
    pedidoRequest.setClienteNome("nome2");
    assertEquals(pedidoRequest.getClienteNome(), "nome2");

  }

  @Test
  public void deveCriarPedidoRequestDomain() {
    PedidoRequest pedidoRequest = new PedidoRequest("123", "nome", new ArrayList<>());

    Pedido pedido = pedidoRequest.toDomain();
    assertNotNull(pedido);
    assertEquals(pedido.getCpf(), "123");
  }

}
