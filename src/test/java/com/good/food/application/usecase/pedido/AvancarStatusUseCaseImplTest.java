package com.good.food.application.usecase.pedido;

import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvancarStatusUseCaseImplTest {


  @InjectMocks
  private AvancarStatusUseCaseImpl provider;
  @Mock
  private PedidoDatabaseGateway pedidoDatabaseGateway;
  
  @Test
  public void deveAvancarStatus() {
    
    Pedido pedido = Pedido.builder().id(UUID.randomUUID()).status(EStatusPedido.EM_PREPARACAO).itemPedido(new ArrayList<>()).build();
    ItemPedido itemPedido = ItemPedido.builder().quantidade(1).preco(BigDecimal.TEN).build();

    pedido.getItemPedido().add(itemPedido);

    when(pedidoDatabaseGateway.findById(anyString())).thenReturn(pedido);
    when(pedidoDatabaseGateway.save(pedido)).thenReturn(pedido);

    Pedido pedidoRetorno = provider.execute("ID");

    assertEquals(pedidoRetorno.getStatus(), EStatusPedido.PRONTO);
  }
  
}
