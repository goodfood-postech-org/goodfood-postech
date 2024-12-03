package com.good.food.driver.db.repository.entity;

import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoEntityImplTest {

  @Test
  public void deveCriarNovoEntity() {
    PedidoEntity pedidoEntity = new PedidoEntity();
    
    assertNotNull(pedidoEntity);
  }

  @Test
  public void deveCriarNovoEntityComValores() {
    PedidoEntity pedidoEntity = new PedidoEntity(
            UUID.randomUUID(),
            "Daniel",
            "123",
            new ArrayList<>(),
            LocalDate.now(),
            LocalDate.now(),
            EStatusPedido.RECEBIDO,
            "asd");

    assertNotNull(pedidoEntity);
    assertEquals(pedidoEntity.getNome(), "Daniel");
  }

  @Test
  public void deveCriarNovoEntityToDomain() {
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(
            UUID.randomUUID(),
            UUID.randomUUID(),
            UUID.randomUUID(),
            "",
            "",
            "",
            10,
            BigDecimal.TEN);

    ItemPedido itemPedido = itemPedidoEntity.toDomain();

    assertNotNull(itemPedido);
    assertEquals(itemPedido.getQuantidade(), 10);
  }
  
}
