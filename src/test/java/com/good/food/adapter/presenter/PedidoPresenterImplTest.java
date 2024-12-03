package com.good.food.adapter.presenter;

import com.good.food.application.presenter.pedido.PedidoResponse;
import com.good.food.domain.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoPresenterImplTest {

  @InjectMocks
  public PedidoPresenterImpl provider;

  @Test
  public void deveRegredirStatus() {
    Pedido pedido = Pedido.builder().id(UUID.randomUUID()).nome("John").build();

    PedidoResponse pedidoResponse = provider.toResponse(pedido);

    assertNotNull(pedidoResponse);
    assertEquals(pedidoResponse.getNome(), "John");
  }
}
